package com.bungeobbang.app.biz.store;

import lombok.Data;

@Data
public class StorePaymentDTO {
	private int storePaymentNum;               //결제방식 고유번호(PK)
   private int storeNum;                     //가게 고유번호(FK)
   private String storePaymentCashmoney;         //현금 결제 가능(Y/N)
   private String storePaymentCard;            //카드 결제 가능(Y/N)
   private String storePaymentAccount;      //계좌이체 결제 가능(Y/N)

}
   
   