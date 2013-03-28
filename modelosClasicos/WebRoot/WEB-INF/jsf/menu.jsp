<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.customer-resources"/>
<div id="contentarea">				
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1>Menu Principal</h1>
			<p class="line">&nbsp;</p>
			<jsp:include page="/WEB-INF/jsf/customer/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/productline/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/product/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/orderdetail/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/office/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/employee/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/payment/menu.jsp" />
			<jsp:include page="/WEB-INF/jsf/purchaseorder/menu.jsp" />
<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>