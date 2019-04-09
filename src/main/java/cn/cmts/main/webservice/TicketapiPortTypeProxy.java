package cn.cmts.main.webservice;

public class TicketapiPortTypeProxy implements cn.cmts.main.webservice.TicketapiPortType {
  private String _endpoint = null;
  private cn.cmts.main.webservice.TicketapiPortType ticketapiPortType = null;
  
  public TicketapiPortTypeProxy() {
    _initTicketapiPortTypeProxy();
  }
  
  public TicketapiPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initTicketapiPortTypeProxy();
  }
  
  private void _initTicketapiPortTypeProxy() {
    try {
      ticketapiPortType = (new cn.cmts.main.webservice.TicketapiLocator()).getticketapiHttpSoap11Endpoint();
      if (ticketapiPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ticketapiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ticketapiPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ticketapiPortType != null)
      ((javax.xml.rpc.Stub)ticketapiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.cmts.main.webservice.TicketapiPortType getTicketapiPortType() {
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType;
  }
  
  public java.lang.String getCinemaPlan(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getCinemaPlan(pAppCode, pCinemaID, pPlanDate, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getPlanSiteStatistic(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getPlanSiteStatistic(pAppCode, pCinemaID, pFeatureAppNo, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getOrderStatus(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getOrderStatus(pAppCode, pCinemaID, pSerialNum, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String liveRealCheckSeatState(java.lang.String pXmlString) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.liveRealCheckSeatState(pXmlString);
  }
  
  public java.lang.String getHallSiteArea(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getHallSiteArea(pAppCode, pCinemaID, pHallID, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String addSPInfo(java.lang.String pXmlString) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.addSPInfo(pXmlString);
  }
  
  public java.lang.String getHall(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getHall(pAppCode, pCinemaID, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String sellTicket(java.lang.String pXmlString) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.sellTicket(pXmlString);
  }
  
  public java.lang.String sellOrder(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pSellPrice, java.lang.String pSettlementPrice, java.lang.String pHandlingFee, java.lang.String pPayType, java.lang.String pPaySeqNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.sellOrder(pAppCode, pCinemaID, pSerialNum, pSellPrice, pSettlementPrice, pHandlingFee, pPayType, pPaySeqNo, pVerifyInfo);
  }
  
  public java.lang.String modifyOrderPayPrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pAppPric, java.lang.String pBalancePric, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.modifyOrderPayPrice(pAppCode, pCinemaID, pOrderNO, pAppPric, pBalancePric, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getOrderMsg(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getOrderMsg(pAppCode, pCinemaID, pOrderNO, pValidCode, pPhoneNum, pVerifyInfo);
  }
  
  public java.lang.String backTicketFromChain(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pDesc, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.backTicketFromChain(pAppCode, pCinemaID, pOrderNO, pDesc, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String appPrintTicket(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pRequestType, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.appPrintTicket(pAppCode, pCinemaID, pOrderNO, pValidCode, pRequestType, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getOrderState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pSerialNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getOrderState(pAppCode, pCinemaID, pSerialNum, pVerifyInfo);
  }
  
  public java.lang.String cinemaIp(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.cinemaIp(pAppCode, pCinemaID, pVerifyInfo);
  }
  
  public java.lang.String getPlanSiteStateRule(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPayType, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getPlanSiteStateRule(pAppCode, pCinemaID, pPayType, pFeatureAppNo, pVerifyInfo);
  }
  
  public java.lang.String getHallSite(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getHallSite(pAppCode, pCinemaID, pHallID, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getJsonSiteState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getJsonSiteState(pAppCode, pCinemaID, pFeatureAppNo, pVerifyInfo);
  }
  
  public java.lang.String getCinemaAllPlan(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getCinemaAllPlan(pAppCode, pCinemaID, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String allCinemas(java.lang.String para, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.allCinemas(para, pVerifyInfo);
  }
  
  public java.lang.String getHallAllSeat(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pHallID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getHallAllSeat(pAppCode, pCinemaID, pHallID, pVerifyInfo);
  }
  
  public java.lang.String getOrderSeatMsg(java.lang.String pAppCode, java.lang.String pOrderNO, java.lang.String pValidCode, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getOrderSeatMsg(pAppCode, pOrderNO, pValidCode, pVerifyInfo);
  }
  
  public java.lang.String backSellGoods(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNo, java.lang.String pPayseqNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.backSellGoods(pAppCode, pCinemaID, pOrderNo, pPayseqNo, pVerifyInfo);
  }
  
  public java.lang.String getCinema(java.lang.String pAppCode, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getCinema(pAppCode, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getOrderInfo(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getOrderInfo(pAppCode, pCinemaID, pOrderNO, pPhoneNum, pVerifyInfo);
  }
  
  public java.lang.String backTicket(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pDesc, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.backTicket(pAppCode, pCinemaID, pOrderNO, pDesc, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String confirmSPInfo(java.lang.String pJsonString) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.confirmSPInfo(pJsonString);
  }
  
  public java.lang.String getSPInfos(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getSPInfos(pAppCode, pCinemaID, pVerifyInfo);
  }
  
  public java.lang.String getFeatureRulePrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getFeatureRulePrice(pAppCode, pCinemaID, pFeatureNo, pVerifyInfo);
  }
  
  public java.lang.String getPlanCannotSellSeat(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerial, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getPlanCannotSellSeat(pAppCode, pCinemaID, pFeatureAppNo, pSerial, pVerifyInfo);
  }
  
  public java.lang.String lockSeats(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerialNum, java.lang.String pSeats, java.lang.String pPhoneNum, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.lockSeats(pAppCode, pCinemaID, pFeatureAppNo, pSerialNum, pSeats, pPhoneNum, pVerifyInfo);
  }
  
  public java.lang.String getCinemaPlanJsonNew(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getCinemaPlanJsonNew(pAppCode, pCinemaID, pPlanDate, pVerifyInfo);
  }
  
  public java.lang.String lockSeatsPrice(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pSerialNum, java.lang.String pSeats, java.lang.String pPhoneNum, java.lang.String pSellPrice, java.lang.String pSettlementPrice, java.lang.String pHandlingFee, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.lockSeatsPrice(pAppCode, pCinemaID, pFeatureAppNo, pSerialNum, pSeats, pPhoneNum, pSellPrice, pSettlementPrice, pHandlingFee, pVerifyInfo);
  }
  
  public java.lang.String unLockOrderCenCin(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pOrderNO, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.unLockOrderCenCin(pAppCode, pCinemaID, pOrderNO, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getPlanSiteStateQlJson(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getPlanSiteStateQlJson(pAppCode, pCinemaID, pFeatureAppNo, pVerifyInfo);
  }
  
  public java.lang.String getPlanSiteState(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pFeatureAppNo, java.lang.String pTokenID, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getPlanSiteState(pAppCode, pCinemaID, pFeatureAppNo, pTokenID, pVerifyInfo);
  }
  
  public java.lang.String getCinemaPlanJson(java.lang.String pAppCode, java.lang.String pCinemaID, java.lang.String pPlanDate, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (ticketapiPortType == null)
      _initTicketapiPortTypeProxy();
    return ticketapiPortType.getCinemaPlanJson(pAppCode, pCinemaID, pPlanDate, pVerifyInfo);
  }
  
  
}