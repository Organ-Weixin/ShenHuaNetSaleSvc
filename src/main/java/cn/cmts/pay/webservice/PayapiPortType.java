/**
 * PayapiPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cmts.pay.webservice;

public interface PayapiPortType extends java.rmi.Remote {
    public java.lang.String chainSpCardPay(java.lang.String partnerCode, java.lang.String sellPlaceNo, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String traceTypeNo, java.lang.String discount, java.lang.String spNo, java.lang.String spCount, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String serialCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String queryTranStatus(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardSPPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceNo, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String updateScore(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String score, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String sPBudgetByLevel(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String memberTypeName, java.lang.String sPInfos, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardRecharge(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainGetDiscount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String sellPlaceNo, java.lang.String featureNo, java.lang.String featureDate, java.lang.String featureTime, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardSPPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String price, java.lang.String tracePrice, java.lang.String discount, java.lang.String SPNo, java.lang.String spCount, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String getMemberType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainCardPay2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainCardPayBack2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardAccount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String accountType, java.lang.String filmNo, java.lang.String operator, java.lang.String startDate, java.lang.String endDate, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String renewalCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String sPPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String tracePrice, java.lang.String discount, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String getDiscount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String featureNo, java.lang.String featureDate, java.lang.String featureTime, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainCdPayNoPt(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String registerMember(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String idNum, java.lang.String memberName, java.lang.String balance, java.lang.String score, java.lang.String memberTypeNo, java.lang.String sex, java.lang.String birthday, java.lang.String email, java.lang.String address, java.lang.String lifeDate, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainSpCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String centerTraceNo, java.lang.String price, java.lang.String tracePrice, java.lang.String spCount, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String registerCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardNo, java.lang.String memoryId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String idNum, java.lang.String memberName, java.lang.String balance, java.lang.String score, java.lang.String memberTypeNo, java.lang.String sex, java.lang.String birthday, java.lang.String email, java.lang.String address, java.lang.String lifeDate, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String queryAllMemberType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String bindingCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String updateCardInfo(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String idNum, java.lang.String birthday, java.lang.String memberName, java.lang.String connectName, java.lang.String address, java.lang.String sex, java.lang.String married, java.lang.String kind, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String chainCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String sPBudget(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String sPInfos, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String loginCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String updatePassWord(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String newPassWord, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String getCardType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardPayNoPt(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String budgetTypeByLevel(java.lang.String reqjson) throws java.rmi.RemoteException;
    public java.lang.String budgetByLevel(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memberTypeName, java.lang.String price, java.lang.String featureNo, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardRecharge2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String queryCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memoryId, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String sPPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceNo, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String serialCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String remoteCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String remoteCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String serialCardRecharge(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String cardRechargeSource(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String queryCardCinema(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memoryId, java.lang.String validateKey) throws java.rmi.RemoteException;
    public java.lang.String getCardTraceRecord(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String startDate, java.lang.String endDate, java.lang.String validateKey) throws java.rmi.RemoteException;
}
