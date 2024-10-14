package com.fproject.app.biz.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import model.common.JDBCUtil;


@Repository
public class ProductDAO {

	private final String INSERT = "INSERT INTO BB_PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, BOARD_NUM, PRODUCT_CATEGORY_NUM) "
            						+ "VALUES (?, ?, ?, ?, ?)";
	private final String INSERT_CRAWLING = "INSERT INTO BB_PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, PRODUCT_CATEGORY_NUM) "
									+ "VALUES (?, ?, ?, ?)";
    private final String UPDATE = "UPDATE BB_PRODUCT SET PRODUCT_NAME = ?, PRODUCT_PRICE = ?, PRODUCT_PROFILE_WAY = ?, BOARD_NUM = ?, PRODUCT_CATEGORY_NUM = ? WHERE PRODUCT_NUM = ?";
    private final String DELETE = "DELETE FROM BB_PRODUCT WHERE PRODUCT_NUM = ?";

    private final String SELECTALL = "SELECT RN, PRODUCT_NUM, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, PRODUCT_CATEGORY_NAME, BOARD_TITLE "
            + "FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NUM DESC) AS RN, PRODUCT_NUM, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, PRODUCT_CATEGORY_NAME, BOARD_TITLE "
            + " FROM BB_VIEW_PRODUCT_JOIN WHERE 1=1 ";
    private final String SELECTALL_ENDPART = " ORDER BY RN) AS PAGED WHERE RN LIMIT ?, ?";

    private final String SELECT_PART_CATEGORY = "AND PRODUCT_CATEGORY_NUM = ?";
    private final String SELECT_PART_NAME = "AND PRODUCT_NAME LIKE CONCAT('%',?,'%')";
    private final String SELECT_PART_TITLE = "AND BOARD_TITLE LIKE CONCAT('%',?,'%')";
    private final String SELECT_PART_PRICE_MIN = "AND PRODUCT_PRICE >= ?";
    private final String SELECT_PART_PRICE_MAX = "AND PRODUCT_PRICE <= ?";

    private final String SELECTONE = "SELECT PRODUCT_NUM, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, BOARD_NUM, PRODUCT_CATEGORY_NUM, PRODUCT_CATEGORY_NAME, BOARD_TITLE, BOARD_CONTENT "
            + "FROM BB_VIEW_PRODUCT_JOIN "
            + "WHERE PRODUCT_NUM = ?";
    
    private final String SELECTONE_CNT = "SELECT COUNT(*) AS CNT FROM BB_PRODUCT bp LEFT JOIN BB_BOARD bb ON bp.BOARD_NUM = bb.BOARD_NUM WHERE 1=1 ";


    public boolean insert(ProductDTO productDTO) {
        System.out.println("log: Product insert start");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        try {
            if (productDTO.getCondition().equals("CRAWLING_ONLY")) {
                System.out.println("log: Product insert condition : CRAWLING_ONLY");
                pstmt = conn.prepareStatement(INSERT_CRAWLING);
                pstmt.setString(1, productDTO.getProductName());
                pstmt.setInt(2, productDTO.getProductPrice());
                pstmt.setString(3, productDTO.getProductProfileWay());
                pstmt.setInt(4, productDTO.getProductCateNum());
            } else {
                pstmt = conn.prepareStatement(INSERT);
                pstmt.setString(1, productDTO.getProductName());
                pstmt.setInt(2, productDTO.getProductPrice());
                pstmt.setString(3, productDTO.getProductProfileWay());
                pstmt.setInt(4, productDTO.getBoardNum());
                pstmt.setInt(5, productDTO.getProductCateNum());
            }

            if (pstmt.executeUpdate() <= 0) {
                System.err.println("log: Product insert execute fail");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("log: Product insert SQLException fail");
            return false;
        } catch (Exception e) {
            System.err.println("log: Product insert Exception fail");
            return false;
        } finally {
            if (!JDBCUtil.disconnect(conn, pstmt)) {
                System.err.println("log: Product insert disconnect fail");
                return false;
            }
            System.out.println("log: Product insert end");
        }
        System.out.println("log: Product insert true");
        return true;
    }

    public boolean update(ProductDTO productDTO) {
        System.out.println("log: Product update start");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, productDTO.getProductName());
            pstmt.setInt(2, productDTO.getProductPrice());
            pstmt.setString(3, productDTO.getProductProfileWay());
            pstmt.setInt(4, productDTO.getBoardNum());
            pstmt.setInt(5, productDTO.getProductCateNum());
            pstmt.setInt(6, productDTO.getProductNum());

            if (pstmt.executeUpdate() <= 0) {
                System.err.println("log: Product update execute fail");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("log: Product update SQLException fail");
            return false;
        } finally {
            if (!JDBCUtil.disconnect(conn, pstmt)) {
                System.err.println("log: Product update disconnect fail");
                return false;
            }
            System.out.println("log: Product update end");
        }
        System.out.println("log: Product update true");
        return true;
    }

    public boolean delete(ProductDTO productDTO) {
        System.out.println("log: Product delete start");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, productDTO.getProductNum());

            if (pstmt.executeUpdate() <= 0) {
                System.err.println("log: Product delete execute fail");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("log: Product delete SQLException fail");
            return false;
        } finally {
            if (!JDBCUtil.disconnect(conn, pstmt)) {
                System.err.println("log: Product delete disconnect fail");
                return false;
            }
            System.out.println("log: Product delete end");
        }
        System.out.println("log: Product delete true");
        return true;
    }

    public ArrayList<ProductDTO> selectAll(ProductDTO productDTO) {
        System.out.println("log: Product selectAll start");
        ArrayList<ProductDTO> datas = new ArrayList<>();
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        try {
            HashMap<String, String> filters = productDTO.getFilterList();
            pstmt = conn.prepareStatement(filterSearch(SELECTALL, filters).append(" " + SELECTALL_ENDPART).toString());
            int placeholderNum = 1;
            placeholderNum = filterKeywordSetter(pstmt, filters, placeholderNum);

            pstmt.setInt(placeholderNum++, productDTO.getStartNum());
            pstmt.setInt(placeholderNum++, productDTO.getEndNum());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO data = new ProductDTO();
                data.setProductNum(rs.getInt("PRODUCT_NUM"));
                data.setProductName(rs.getString("PRODUCT_NAME"));
                data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                data.setProductProfileWay(rs.getString("PRODUCT_PROFILE_WAY"));
                data.setProductCateName(rs.getString("PRODUCT_CATEGORY_NAME"));
                data.setBoardTitle(rs.getString("BOARD_TITLE"));
                datas.add(data);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("log: Product selectAll SQLException fail");
            datas.clear();
        } finally {
            if (!JDBCUtil.disconnect(conn, pstmt)) {
                System.err.println("log: Product selectAll disconnect fail");
                datas.clear();
            }
        }
        return datas;
    }

    public ProductDTO selectOne(ProductDTO productDTO) {
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        ProductDTO data = null;
        try {
            pstmt = conn.prepareStatement(SELECTONE);
            pstmt.setInt(1, productDTO.getProductNum());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new ProductDTO();
                data.setProductNum(rs.getInt("PRODUCT_NUM"));
                data.setProductName(rs.getString("PRODUCT_NAME"));
                data.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                data.setProductProfileWay(rs.getString("PRODUCT_PROFILE_WAY"));
                data.setProductCateName(rs.getString("PRODUCT_CATEGORY_NAME"));
                data.setProductCateNum(rs.getInt("PRODUCT_CATEGORY_NUM"));
                data.setBoardNum(rs.getInt("BOARD_NUM"));
                data.setBoardTitle(rs.getString("BOARD_TITLE"));
                data.setBoardContent(rs.getString("BOARD_CONTENT"));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("log: Product selectOne SQLException fail");
            return null;
        } finally {
            if (!JDBCUtil.disconnect(conn, pstmt)) {
                System.err.println("log: Product selectOne disconnect fail");
                return null;
            }
        }
        return data;
    }

    private StringBuilder filterSearch(String startQuery, HashMap<String, String> filters) {
        StringBuilder query = new StringBuilder(startQuery);
        if (filters != null && !filters.isEmpty()) {
            for (String key : filters.keySet()) {
                if (key.equals("GET_MD_CATEGORY")) {
                    query.append(" ").append(SELECT_PART_CATEGORY);
                } else if (key.equals("GET_MD_KEYWORD")) {
                    query.append(" ").append(SELECT_PART_NAME);
                } else if (key.equals("GET_MD_TITLE")) {
                    query.append(" ").append(SELECT_PART_TITLE);
                } else if (key.equals("GET_MD_MINPRICE")) {
                    query.append(" ").append(SELECT_PART_PRICE_MIN);
                } else if (key.equals("GET_MD_MAXPRICE")) {
                    query.append(" ").append(SELECT_PART_PRICE_MAX);
                }
            }
        }
        return query;
    }

    private int filterKeywordSetter(PreparedStatement pstmt, HashMap<String, String> filters, int placeholderNum) {
        if (filters != null && !filters.isEmpty()) {
            for (Entry<String, String> keyword : filters.entrySet()) {
                try {
                    if (keyword.getKey().equals("GET_MD_CATEGORY")) {
                        pstmt.setInt(placeholderNum++, Integer.parseInt(keyword.getValue()));
                    } else if (keyword.getKey().equals("GET_MD_KEYWORD")) {
                        pstmt.setString(placeholderNum++, keyword.getValue());
                    } else if (keyword.getKey().equals("GET_MD_TITLE")) {
                        pstmt.setString(placeholderNum++, keyword.getValue());
                    } else if (keyword.getKey().equals("GET_MD_MINPRICE")) {
                        pstmt.setInt(placeholderNum++, Integer.parseInt(keyword.getValue()));
                    } else if (keyword.getKey().equals("GET_MD_MAXPRICE")) {
                        pstmt.setInt(placeholderNum++, Integer.parseInt(keyword.getValue()));
                    }
                } catch (NumberFormatException | SQLException e) {
                    return -1;
                }
            }
        }
        return placeholderNum;
    }
}
