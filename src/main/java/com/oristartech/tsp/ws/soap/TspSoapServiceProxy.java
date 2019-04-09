package com.oristartech.tsp.ws.soap;

public class TspSoapServiceProxy implements com.oristartech.tsp.ws.soap.TspSoapService {
  private String _endpoint = null;
  private com.oristartech.tsp.ws.soap.TspSoapService tspSoapService = null;
  
  public TspSoapServiceProxy() {
    _initTspSoapServiceProxy();
  }
  
  public TspSoapServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTspSoapServiceProxy();
  }
  
  private void _initTspSoapServiceProxy() {
    try {
      tspSoapService = (new com.oristartech.tsp.ws.soap.TspSoapServiceImplServiceLocator()).getTspSoapServiceImplPort();
      if (tspSoapService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tspSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tspSoapService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tspSoapService != null)
      ((javax.xml.rpc.Stub)tspSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oristartech.tsp.ws.soap.TspSoapService getTspSoapService() {
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService;
  }
  
  public java.lang.String memberTransactionCancel(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOldTransactionNo, java.lang.String pTransactionNo, java.lang.String pChannelType, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberTransactionCancel(pAppCode, pCinemaCode, pOldTransactionNo, pTransactionNo, pChannelType, pCompress, pVerifyInfo);
  }
  
  public java.lang.String giveTicket(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pArrayIn, java.lang.String pLoginNum, java.lang.String pChannel, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.giveTicket(pAppCode, pCinemaCode, pArrayIn, pLoginNum, pChannel, pCompress, pVerifyInfo);
  }
  
  public java.lang.String modifyActivityExeTime(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pRuleIds, java.lang.String pAmounts, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.modifyActivityExeTime(pAppCode, pCinemaCode, pRuleIds, pAmounts, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberConsumeOrder(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pOrderCode, java.lang.String pOrderFormNum, java.lang.String pTransactionTime, java.lang.Float pAmount, java.lang.String pGoodsCategory, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.String pTicketNum, java.lang.String pSessionNumAndDiscountNum, java.lang.Float pTicketIntegralAmount, java.lang.Float pGoodsIntegralAmount, java.lang.Float pIntegralMultiple, java.lang.String pRuleIdsAndRunTimes, java.lang.String pOrderPay, java.lang.String pOrderGoods, java.lang.String pRuleGoodsAmounts, java.lang.String pChannel, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberConsumeOrder(pAppCode, pCinemaCode, pLoginNum, pOrderCode, pOrderFormNum, pTransactionTime, pAmount, pGoodsCategory, pTicketAmount, pGoodsAmount, pTicketNum, pSessionNumAndDiscountNum, pTicketIntegralAmount, pGoodsIntegralAmount, pIntegralMultiple, pRuleIdsAndRunTimes, pOrderPay, pOrderGoods, pRuleGoodsAmounts, pChannel, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryOrderStatus(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOrderCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryOrderStatus(pAppCode, pCinemaCode, pOrderCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryMerchandise(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPageSize, java.lang.String pPageNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryMerchandise(pAppCode, pCinemaCode, pPageSize, pPageNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String getIntegralOrderInfoByOrderNum(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOrderFormNum, java.lang.String pTerminalFlowNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.getIntegralOrderInfoByOrderNum(pAppCode, pCinemaCode, pOrderFormNum, pTerminalFlowNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String submitOrder(java.lang.String submitOrderXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.submitOrder(submitOrderXml);
  }
  
  public java.lang.String queryFilmInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPlanDate, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryFilmInfo(pAppCode, pCinemaCode, pPlanDate, pCompress, pVerifyInfo);
  }
  
  public java.lang.String releaseSeat(java.lang.String releaseSeatXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.releaseSeat(releaseSeatXml);
  }
  
  public java.lang.String queryIntegralFlowInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pStartDate, java.lang.String pEndDate, java.lang.String pPageSize, java.lang.String pPageNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryIntegralFlowInfo(pAppCode, pCinemaCode, pLoginNum, pStartDate, pEndDate, pPageSize, pPageNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String createMerOrder(java.lang.String createMerOrderXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.createMerOrder(createMerOrderXml);
  }
  
  public java.lang.String applyFetchTicket(java.lang.String applyFetchTicketXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.applyFetchTicket(applyFetchTicketXml);
  }
  
  public java.lang.String autoMatchMarketActivityExeV3P0(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFacts, java.lang.String pIsOnePriceResult, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.autoMatchMarketActivityExeV3P0(pAppCode, pCinemaCode, pFacts, pIsOnePriceResult, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryCinemaInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryCinemaInfo(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryDiscountActivity(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFacts, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryDiscountActivity(pAppCode, pCinemaCode, pFacts, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryScreenSeat(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pScreenCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryScreenSeat(pAppCode, pCinemaCode, pScreenCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryMemberInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryMemberInfo(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pCompress, pVerifyInfo);
  }
  
  public java.lang.String resetMemberPassword(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pResetPassword, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.resetMemberPassword(pAppCode, pCinemaCode, pLoginNum, pResetPassword, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryPlanInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPlanDate, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryPlanInfo(pAppCode, pCinemaCode, pPlanDate, pCompress, pVerifyInfo);
  }
  
  public java.lang.String modifyMemberPassword(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pOldPassword, java.lang.String pNewPassword, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.modifyMemberPassword(pAppCode, pCinemaCode, pLoginNum, pOldPassword, pNewPassword, pCompress, pVerifyInfo);
  }
  
  public java.lang.String verficationOfOne(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pPasswd, java.lang.String pDataPacket, java.lang.String pLoginNum, java.lang.String pChannel, java.lang.String pTerminalNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.verficationOfOne(pAppCode, pCinemaCode, pTicketNum, pPasswd, pDataPacket, pLoginNum, pChannel, pTerminalNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryOrderDetail(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOrderCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryOrderDetail(pAppCode, pCinemaCode, pOrderCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryTicketOrder(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTicketOrder(pAppCode, pCinemaCode, pTicketNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryRetailTicketInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryRetailTicketInfo(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryTicketOfMarketing(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTicketOfMarketing(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String fetchTicket(java.lang.String fetchTicketXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.fetchTicket(fetchTicketXml);
  }
  
  public java.lang.String memberRefund(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFlowNum, java.lang.String pTransactionNo, java.lang.Float pAmount, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.String pChannelType, java.lang.String pGoods, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberRefund(pAppCode, pCinemaCode, pFlowNum, pTransactionNo, pAmount, pTicketAmount, pGoodsAmount, pChannelType, pGoods, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberConsumeV2P0(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.Float pAmount, java.lang.String pGoodsCategory, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.String pTicketNum, java.lang.String pChannelType, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberConsumeV2P0(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pOrderCode, pTransactionNo, pAmount, pGoodsCategory, pTicketAmount, pGoodsAmount, pTicketNum, pChannelType, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String modifyMemberInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pPassword, java.lang.String pMobileNum, java.lang.String pUserName, java.lang.String pSex, java.lang.String pBirthday, java.lang.String pCreditNum, java.lang.String pEmail, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.modifyMemberInfo(pAppCode, pCinemaCode, pLoginNum, pPassword, pMobileNum, pUserName, pSex, pBirthday, pCreditNum, pEmail, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryMemberFlowInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pStartDate, java.lang.String pEndDate, java.lang.String pPageSize, java.lang.String pPageNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryMemberFlowInfo(pAppCode, pCinemaCode, pLoginNum, pStartDate, pEndDate, pPageSize, pPageNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String getMoneyOrderByOrderNum(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOrderFormNum, java.lang.String pTerminalFlowNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.getMoneyOrderByOrderNum(pAppCode, pCinemaCode, pOrderFormNum, pTerminalFlowNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberConsume(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pChannelType, java.lang.Float pAmount, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.Float pIntegralAmount, java.lang.Float pIntegralMultiple, java.lang.String pGoods, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberConsume(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pChannelType, pAmount, pOrderCode, pTransactionNo, pTicketAmount, pGoodsAmount, pIntegralAmount, pIntegralMultiple, pGoods, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryAvailCinema(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryAvailCinema(pAppCode, pCinemaCode, pLoginNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryFavorableActivity(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFacts, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryFavorableActivity(pAppCode, pCinemaCode, pFacts, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryOrders(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTransactionType, java.lang.String pOrderSource, java.lang.String pIsShowDetail, java.lang.String pTransactionDate, java.lang.String pPageSize, java.lang.String pPageNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryOrders(pAppCode, pCinemaCode, pTransactionType, pOrderSource, pIsShowDetail, pTransactionDate, pPageSize, pPageNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String preordainRetailTicketRevocation(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pArrayIn, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.preordainRetailTicketRevocation(pAppCode, pCinemaCode, pArrayIn, pCompress, pVerifyInfo);
  }
  
  public java.lang.String integralTransactionCancel(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOldTransactionNo, java.lang.String pTransactionNo, java.lang.String pChannelType, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.integralTransactionCancel(pAppCode, pCinemaCode, pOldTransactionNo, pTransactionNo, pChannelType, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryCinemaParams(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryCinemaParams(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String getFilmInfo(java.lang.String pAppCode, java.lang.String pPublishDateStart, java.lang.String pPublishDateEnd, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.getFilmInfo(pAppCode, pPublishDateStart, pPublishDateEnd, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberCharge(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pChargeType, java.lang.String pChargeTypeName, java.lang.String pChannelType, java.lang.String pAccountType, java.lang.Float pChargeAmount, java.lang.String pChargeActivityId, java.lang.String pChargeClass, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberCharge(pAppCode, pCinemaCode, pLoginNum, pChargeType, pChargeTypeName, pChannelType, pAccountType, pChargeAmount, pChargeActivityId, pChargeClass, pOrderCode, pTransactionNo, pCompress, pVerifyInfo);
  }
  
  public java.lang.String lockSeat(java.lang.String lockSeatXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.lockSeat(lockSeatXml);
  }
  
  public java.lang.String queryTicketInfo(java.lang.String queryTicketInfoXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTicketInfo(queryTicketInfoXml);
  }
  
  public java.lang.String modifyMemberLoginPassword(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pOldLoginPassword, java.lang.String pNewLoginPassword, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.modifyMemberLoginPassword(pAppCode, pCinemaCode, pLoginNum, pOldLoginPassword, pNewLoginPassword, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryPlanInfoAndSeatLevelPrice(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPlanStartDate, java.lang.String pPlanEndDate, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryPlanInfoAndSeatLevelPrice(pAppCode, pCinemaCode, pPlanStartDate, pPlanEndDate, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryDeliveryStatus(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPrintNo, java.lang.String pVerifyCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryDeliveryStatus(pAppCode, pCinemaCode, pPrintNo, pVerifyCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String ticketConsume(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pPasswd, java.lang.String pRuleId, java.lang.String pChannel, java.lang.String pTerminalFlowNum, java.lang.String pTicketSaleOrderNo, java.lang.Float pCreditPrice, java.lang.Float pAmount, java.lang.String pTerminalNum, java.lang.String pConsumeTime, java.lang.String pTicketOrderGoods, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.ticketConsume(pAppCode, pCinemaCode, pTicketNum, pPasswd, pRuleId, pChannel, pTerminalFlowNum, pTicketSaleOrderNo, pCreditPrice, pAmount, pTerminalNum, pConsumeTime, pTicketOrderGoods, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryPlanInfoByDatePeriod(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPlanStartDate, java.lang.String pPlanEndDate, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryPlanInfoByDatePeriod(pAppCode, pCinemaCode, pPlanStartDate, pPlanEndDate, pCompress, pVerifyInfo);
  }
  
  public java.lang.String ticketCheckUnlock(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pChannel, java.lang.String pTerminalNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.ticketCheckUnlock(pAppCode, pCinemaCode, pTicketNum, pChannel, pTerminalNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String phoneNumRegAndCharge(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pMobileNum, java.lang.String pLmsPassword, java.lang.String pLoginPasswd, java.lang.String pLevelCode, java.lang.String pRegCinemaMember, java.lang.String pName, java.lang.String pSex, java.lang.String pBirthday, java.lang.String pCreditNum, java.lang.String pEmail, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.Float pChargeAmount, java.lang.String pChargeType, java.lang.String pChargeTypeName, java.lang.String pAccountType, java.lang.String pChannelType, java.lang.String pCheckAmountLimit, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.phoneNumRegAndCharge(pAppCode, pCinemaCode, pMobileNum, pLmsPassword, pLoginPasswd, pLevelCode, pRegCinemaMember, pName, pSex, pBirthday, pCreditNum, pEmail, pOrderCode, pTransactionNo, pChargeAmount, pChargeType, pChargeTypeName, pAccountType, pChannelType, pCheckAmountLimit, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryPlanSeat(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFeatureAppNo, java.lang.String pStatus, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryPlanSeat(pAppCode, pCinemaCode, pFeatureAppNo, pStatus, pCompress, pVerifyInfo);
  }
  
  public java.lang.String cancelOrder(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPrintNo, java.lang.String pVerifyCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.cancelOrder(pAppCode, pCinemaCode, pPrintNo, pVerifyCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String integralRefund(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pConsumeType, java.lang.String pFlowNum, java.lang.String pTransactionNo, java.lang.Float pAmount, java.lang.String pChannelType, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.integralRefund(pAppCode, pCinemaCode, pConsumeType, pFlowNum, pTransactionNo, pAmount, pChannelType, pCompress, pVerifyInfo);
  }
  
  public java.lang.String preordainRetailTicket(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pArrayIn, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.preordainRetailTicket(pAppCode, pCinemaCode, pArrayIn, pCompress, pVerifyInfo);
  }
  
  public java.lang.String verifyMemberLogin(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.verifyMemberLogin(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberRefundV2P0(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFlowNum, java.lang.String pTransactionNo, java.lang.Float pAmount, java.lang.String pGoodsCategory, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.String pTicketNum, java.lang.String pChannelType, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberRefundV2P0(pAppCode, pCinemaCode, pFlowNum, pTransactionNo, pAmount, pGoodsCategory, pTicketAmount, pGoodsAmount, pTicketNum, pChannelType, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryMemberTickets(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pTicketStatus, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryMemberTickets(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pTicketStatus, pCompress, pVerifyInfo);
  }
  
  public java.lang.String giveIntegral(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pChannelType, java.lang.Float pAmount, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.giveIntegral(pAppCode, pCinemaCode, pLoginNum, pChannelType, pAmount, pOrderCode, pTransactionNo, pCompress, pVerifyInfo);
  }
  
  public java.lang.String submitMerOrder(java.lang.String submitMerOrderXml) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.submitMerOrder(submitMerOrderXml);
  }
  
  public java.lang.String queryPlanSeatPrice(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFeatureAppNo, java.lang.String pStatus, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryPlanSeatPrice(pAppCode, pCinemaCode, pFeatureAppNo, pStatus, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryCinemaList(java.lang.String pAppCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryCinemaList(pAppCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String querySeatInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pScreenCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.querySeatInfo(pAppCode, pCinemaCode, pScreenCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String verficationOfMany(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pPasswd, java.lang.String pTicketSaleOrderNo, java.lang.String pLoginNum, java.lang.String pChannel, java.lang.String pTerminalNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.verficationOfMany(pAppCode, pCinemaCode, pTicketNum, pPasswd, pTicketSaleOrderNo, pLoginNum, pChannel, pTerminalNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryTransactionInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTradeTimeStart, java.lang.String pTradeTimeEnd, java.lang.String pTradeType, java.lang.String pTradeChannel, java.lang.String pGdTradeCode, java.lang.String pIsReturnDetail, java.lang.String pPageSize, java.lang.String pPageNo, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTransactionInfo(pAppCode, pCinemaCode, pTradeTimeStart, pTradeTimeEnd, pTradeType, pTradeChannel, pGdTradeCode, pIsReturnDetail, pPageSize, pPageNo, pCompress, pVerifyInfo);
  }
  
  public java.lang.String modifyActivityExeTimeV2P0(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pRuleIds, java.lang.String pAmounts, java.lang.String pOrderFormNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.modifyActivityExeTimeV2P0(pAppCode, pCinemaCode, pRuleIds, pAmounts, pOrderFormNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryTicketRuleInfo(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTicketRuleInfo(pAppCode, pCinemaCode, pTicketNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String activityInvokeMember(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pRuleId, java.lang.String pActionId, java.lang.String pOldTransactionNo, java.lang.String pChannelType, java.lang.String pTransactionNo, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.activityInvokeMember(pAppCode, pCinemaCode, pLoginNum, pRuleId, pActionId, pOldTransactionNo, pChannelType, pTransactionNo, pCompress, pVerifyInfo);
  }
  
  public java.lang.String memberRefundOrder(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pOrderCode, java.lang.String pOrderFormNum, java.lang.String pOldOrderCode, java.lang.String pTransactionTime, java.lang.Float pAmount, java.lang.String pGoodsCategory, java.lang.Float pTicketAmount, java.lang.Float pGoodsAmount, java.lang.String pTicketNum, java.lang.String pSessionNumAndDiscountNum, java.lang.Float pTicketIntegralAmount, java.lang.Float pGoodsIntegralAmount, java.lang.String pCancelMarketingActivity, java.lang.String pOrderPay, java.lang.String pOrderGoods, java.lang.String pRuleGoodsAmounts, java.lang.String pChannel, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.memberRefundOrder(pAppCode, pCinemaCode, pOrderCode, pOrderFormNum, pOldOrderCode, pTransactionTime, pAmount, pGoodsCategory, pTicketAmount, pGoodsAmount, pTicketNum, pSessionNumAndDiscountNum, pTicketIntegralAmount, pGoodsIntegralAmount, pCancelMarketingActivity, pOrderPay, pOrderGoods, pRuleGoodsAmounts, pChannel, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String integralConsume(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLmsPassword, java.lang.String pChannelType, java.lang.String pConsumeType, java.lang.Float pAmount, java.lang.String pOrderCode, java.lang.String pTransactionNo, java.lang.String pGoods, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.integralConsume(pAppCode, pCinemaCode, pLoginNum, pLmsPassword, pChannelType, pConsumeType, pAmount, pOrderCode, pTransactionNo, pGoods, pCompress, pVerifyInfo);
  }
  
  public java.lang.String checkMemberByLoginPwd(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pLoginPasswd, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.checkMemberByLoginPwd(pAppCode, pCinemaCode, pLoginNum, pLoginPasswd, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryChargeActivity(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pLoginNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryChargeActivity(pAppCode, pCinemaCode, pLoginNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String getCinemaAllPlan(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.getCinemaAllPlan(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryMemberLevel(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryMemberLevel(pAppCode, pCinemaCode, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryFilmInfoByDatePeriod(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pPlanStartDate, java.lang.String pPlanEndDate, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryFilmInfoByDatePeriod(pAppCode, pCinemaCode, pPlanStartDate, pPlanEndDate, pCompress, pVerifyInfo);
  }
  
  public java.lang.String getPlanSeatState(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFeatureAppNo, java.lang.String pStatus, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.getPlanSeatState(pAppCode, pCinemaCode, pFeatureAppNo, pStatus, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryFavorablePrice(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pFacts, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryFavorablePrice(pAppCode, pCinemaCode, pFacts, pCompress, pVerifyInfo);
  }
  
  public java.lang.String phoneNumReg(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pMobileNum, java.lang.String pLmsPassword, java.lang.String pLoginPasswd, java.lang.String pName, java.lang.String pSex, java.lang.String pBirthday, java.lang.String pCreditNum, java.lang.String pEmail, java.lang.String pOperator, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.phoneNumReg(pAppCode, pCinemaCode, pMobileNum, pLmsPassword, pLoginPasswd, pName, pSex, pBirthday, pCreditNum, pEmail, pOperator, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryCinemaBusinessStatus(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pBusinessType, java.lang.String pBusinessDate, java.lang.String pBusinessStatus, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryCinemaBusinessStatus(pAppCode, pCinemaCode, pBusinessType, pBusinessDate, pBusinessStatus, pCompress, pVerifyInfo);
  }
  
  public java.lang.String queryTicketValidityPeriod(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNums, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.queryTicketValidityPeriod(pAppCode, pCinemaCode, pTicketNums, pCompress, pVerifyInfo);
  }
  
  public java.lang.String ticketReturnProcess(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pTicketNum, java.lang.String pChannel, java.lang.String pTerminalNum, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.ticketReturnProcess(pAppCode, pCinemaCode, pTicketNum, pChannel, pTerminalNum, pCompress, pVerifyInfo);
  }
  
  public java.lang.String extractRetailTicket(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pArrayIn, java.lang.String pMobileNum, java.lang.String pIsSendMsg, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.extractRetailTicket(pAppCode, pCinemaCode, pArrayIn, pMobileNum, pIsSendMsg, pCompress, pVerifyInfo);
  }
  
  public java.lang.String generalInvoker(java.lang.String pAppCode, java.lang.String pCinemaCode, java.lang.String pActionName, java.lang.String pUUID, java.lang.String pActionParam, java.lang.String pCompress, java.lang.String pVerifyInfo) throws java.rmi.RemoteException{
    if (tspSoapService == null)
      _initTspSoapServiceProxy();
    return tspSoapService.generalInvoker(pAppCode, pCinemaCode, pActionName, pUUID, pActionParam, pCompress, pVerifyInfo);
  }
  
  
}