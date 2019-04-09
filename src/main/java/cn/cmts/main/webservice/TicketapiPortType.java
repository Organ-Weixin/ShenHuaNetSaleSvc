/**
 * TicketapiPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cmts.main.webservice;

public interface TicketapiPortType extends java.rmi.Remote {
    public java.lang.String getCinemaPlan(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getPlanSiteStatistic(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getOrderStatus(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String liveRealCheckSeatState(java.lang.String pXmlString) throws java.rmi.RemoteException;
    public java.lang.String getHallSiteArea(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String addSPInfo(java.lang.String pXmlString) throws java.rmi.RemoteException;
    public java.lang.String getHall(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String sellTicket(java.lang.String pXmlString) throws java.rmi.RemoteException;
    public java.lang.String sellOrder(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pSellPrice, java.lang.String pSettlementPrice, java.lang.String pHandlingFee, java.lang.String pPayType, java.lang.String pPaySeqNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String modifyOrderPayPrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pAppPric, java.lang.String pBalancePric, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getOrderMsg(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String backTicketFromChain(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pDesc, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String appPrintTicket(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pRequestType, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getOrderState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String cinemaIp(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getPlanSiteStateRule(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPayType, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getHallSite(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getJsonSiteState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getCinemaAllPlan(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String allCinemas(java.lang.String para, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getHallAllSeat(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getOrderSeatMsg(java.lang.String pAppCode, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String backSellGoods(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNo, java.lang.String pPayseqNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getCinema(java.lang.String pAppCode, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getOrderInfo(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String backTicket(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pDesc, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String confirmSPInfo(java.lang.String pJsonString) throws java.rmi.RemoteException;
    public java.lang.String getSPInfos(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getFeatureRulePrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getPlanCannotSellSeat(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerial, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String lockSeats(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerialNum, java.lang.String pSeats, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getCinemaPlanJsonNew(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String lockSeatsPrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerialNum, java.lang.String pSeats, java.lang.String pPhoneNum, java.lang.String pSellPrice, java.lang.String pSettlementPrice, java.lang.String pHandlingFee, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String unLockOrderCenCin(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getPlanSiteStateQlJson(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getPlanSiteState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
    public java.lang.String getCinemaPlanJson(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pVerifyInfo) throws java.rmi.RemoteException;
}
