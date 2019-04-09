package cn.cmts.pay.webservice;

public class PayapiPortTypeProxy implements cn.cmts.pay.webservice.PayapiPortType {
  private String _endpoint = null;
  private cn.cmts.pay.webservice.PayapiPortType payapiPortType = null;
  
  public PayapiPortTypeProxy() {
    _initPayapiPortTypeProxy();
  }
  
  public PayapiPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPayapiPortTypeProxy();
  }
  
  private void _initPayapiPortTypeProxy() {
    try {
      payapiPortType = (new cn.cmts.pay.webservice.PayapiLocator()).getpayapiHttpSoap11Endpoint();
      if (payapiPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)payapiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)payapiPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (payapiPortType != null)
      ((javax.xml.rpc.Stub)payapiPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.cmts.pay.webservice.PayapiPortType getPayapiPortType() {
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType;
  }
  
  public java.lang.String chainSpCardPay(java.lang.String partnerCode, java.lang.String sellPlaceNo, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String traceTypeNo, java.lang.String discount, java.lang.String spNo, java.lang.String spCount, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainSpCardPay(partnerCode, sellPlaceNo, placeNo, partnerId, cardId, passWord, mobilePhone, traceTypeNo, discount, spNo, spCount, oldPrice, tracePrice, traceMemo, validateKey);
  }
  
  public java.lang.String serialCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.serialCardPay(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, traceMemo, validateKey);
  }
  
  public java.lang.String queryTranStatus(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.queryTranStatus(partnerCode, placeNo, partnerId, validateKey);
  }
  
  public java.lang.String cardSPPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceNo, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardSPPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceNo, price, traceMemo, validateKey);
  }
  
  public java.lang.String updateScore(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String score, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.updateScore(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, score, traceMemo, validateKey);
  }
  
  public java.lang.String cardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardPay(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, traceMemo, validateKey);
  }
  
  public java.lang.String chainCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainCardPay(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, traceMemo, validateKey);
  }
  
  public java.lang.String cardRecharge(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardRecharge(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, price, traceMemo, validateKey);
  }
  
  public java.lang.String chainGetDiscount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String sellPlaceNo, java.lang.String featureNo, java.lang.String featureDate, java.lang.String featureTime, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainGetDiscount(partnerCode, placeNo, partnerId, cardId, mobilePhone, sellPlaceNo, featureNo, featureDate, featureTime, validateKey);
  }
  
  public java.lang.String cardSPPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String price, java.lang.String tracePrice, java.lang.String discount, java.lang.String SPNo, java.lang.String spCount, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardSPPay(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceTypeNo, oldPrice, price, tracePrice, discount, SPNo, spCount, traceMemo, validateKey);
  }
  
  public java.lang.String getMemberType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.getMemberType(partnerCode, placeNo, cardId, mobilePhone, validateKey);
  }
  
  public java.lang.String chainCardPay2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainCardPay2(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, userName, traceMemo, validateKey);
  }
  
  public java.lang.String cardAccount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String accountType, java.lang.String filmNo, java.lang.String operator, java.lang.String startDate, java.lang.String endDate, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardAccount(partnerCode, placeNo, partnerId, cardId, mobilePhone, accountType, filmNo, operator, startDate, endDate, validateKey);
  }
  
  public java.lang.String renewalCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.renewalCard(partnerCode, placeNo, partnerId, cardId, mobilePhone, validateKey);
  }
  
  public java.lang.String chainCardPayBack2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainCardPayBack2(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceType, traceNo, tracePrice, price, userName, traceMemo, validateKey);
  }
  
  public java.lang.String getDiscount(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String featureNo, java.lang.String featureDate, java.lang.String featureTime, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.getDiscount(partnerCode, placeNo, partnerId, cardId, mobilePhone, featureNo, featureDate, featureTime, validateKey);
  }
  
  public java.lang.String chainCdPayNoPt(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainCdPayNoPt(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, traceMemo, validateKey);
  }
  
  public java.lang.String registerMember(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String idNum, java.lang.String memberName, java.lang.String balance, java.lang.String score, java.lang.String memberTypeNo, java.lang.String sex, java.lang.String birthday, java.lang.String email, java.lang.String address, java.lang.String lifeDate, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.registerMember(partnerCode, placeNo, partnerId, passWord, mobilePhone, idNum, memberName, balance, score, memberTypeNo, sex, birthday, email, address, lifeDate, traceMemo, validateKey);
  }
  
  public java.lang.String chainSpCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String centerTraceNo, java.lang.String price, java.lang.String tracePrice, java.lang.String spCount, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainSpCardPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, centerTraceNo, price, tracePrice, spCount, traceMemo, validateKey);
  }
  
  public java.lang.String registerCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardNo, java.lang.String memoryId, java.lang.String passWord, java.lang.String mobilePhone, java.lang.String idNum, java.lang.String memberName, java.lang.String balance, java.lang.String score, java.lang.String memberTypeNo, java.lang.String sex, java.lang.String birthday, java.lang.String email, java.lang.String address, java.lang.String lifeDate, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.registerCard(partnerCode, placeNo, partnerId, cardNo, memoryId, passWord, mobilePhone, idNum, memberName, balance, score, memberTypeNo, sex, birthday, email, address, lifeDate, traceMemo, validateKey);
  }
  
  public java.lang.String cardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceType, traceNo, tracePrice, price, traceMemo, validateKey);
  }
  
  public java.lang.String queryAllMemberType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.queryAllMemberType(partnerCode, placeNo, validateKey);
  }
  
  public java.lang.String bindingCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.bindingCard(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, validateKey);
  }
  
  public java.lang.String updateCardInfo(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String idNum, java.lang.String birthday, java.lang.String memberName, java.lang.String connectName, java.lang.String address, java.lang.String sex, java.lang.String married, java.lang.String kind, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.updateCardInfo(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, idNum, birthday, memberName, connectName, address, sex, married, kind, validateKey);
  }
  
  public java.lang.String chainCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.chainCardPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceType, traceNo, tracePrice, price, traceMemo, validateKey);
  }
  
  public java.lang.String loginCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.loginCard(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, validateKey);
  }
  
  public java.lang.String updatePassWord(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String newPassWord, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.updatePassWord(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, newPassWord, validateKey);
  }
  
  public java.lang.String getCardType(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.getCardType(partnerCode, placeNo, validateKey);
  }
  
  public java.lang.String cardPayNoPt(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardPayNoPt(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, traceMemo, validateKey);
  }
  
  public java.lang.String cardRecharge2(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardRecharge2(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, price, userName, traceMemo, validateKey);
  }
  
  public java.lang.String queryCard(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memoryId, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.queryCard(partnerCode, placeNo, partnerId, memoryId, validateKey);
  }
  
  public java.lang.String budgetByLevel(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memberTypeName, java.lang.String price, java.lang.String featureNo, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.budgetByLevel(partnerCode, placeNo, partnerId, memberTypeName, price, featureNo, traceMemo, validateKey);
  }
  
  public java.lang.String serialCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.serialCardPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, traceType, traceNo, tracePrice, price, traceMemo, validateKey);
  }
  
  public java.lang.String remoteCardPayBack(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceType, java.lang.String traceNo, java.lang.String tracePrice, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.remoteCardPayBack(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceType, traceNo, tracePrice, price, userName, traceMemo, validateKey);
  }
  
  public java.lang.String remoteCardPay(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String sellPlaceNo, java.lang.String traceTypeNo, java.lang.String oldPrice, java.lang.String tracePrice, java.lang.String discount, java.lang.String featureNo, java.lang.String filmNo, java.lang.String ticketNum, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.remoteCardPay(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, sellPlaceNo, traceTypeNo, oldPrice, tracePrice, discount, featureNo, filmNo, ticketNum, userName, traceMemo, validateKey);
  }
  
  public java.lang.String serialCardRecharge(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.serialCardRecharge(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, price, traceMemo, validateKey);
  }
  
  public java.lang.String cardRechargeSource(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String price, java.lang.String userName, java.lang.String traceMemo, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.cardRechargeSource(partnerCode, placeNo, partnerId, cardId, mobilePhone, passWord, price, userName, traceMemo, validateKey);
  }
  
  public java.lang.String getCardTraceRecord(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String cardId, java.lang.String mobilePhone, java.lang.String passWord, java.lang.String startDate, java.lang.String endDate, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.getCardTraceRecord(partnerCode, placeNo, cardId, mobilePhone, passWord, startDate, endDate, validateKey);
  }
  
  public java.lang.String queryCardCinema(java.lang.String partnerCode, java.lang.String placeNo, java.lang.String partnerId, java.lang.String memoryId, java.lang.String validateKey) throws java.rmi.RemoteException{
    if (payapiPortType == null)
      _initPayapiPortTypeProxy();
    return payapiPortType.queryCardCinema(partnerCode, placeNo, partnerId, memoryId, validateKey);
  }
  
  
}