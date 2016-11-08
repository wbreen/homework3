<%--
Copyright: 2016 Jenny Faig & Tyler LaVecchia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "elon" uri="/WEB-INF/tlds/currencyFormat.tld" %>
<c:import url="/includes/header.html" />

<form method="post">
  <h1>Future Value Calculator</h1>
  
  <label class="returnAmount">Investment Amount:</label>
  <span class="returnAmountNum">
    ${calculation.principal}
  </span><br>

  <label class="returnRate">Yearly Interest Rate:</label>
  <span class="returnRateNum">
    ${calculation.rate}
  </span><br>

  <label class="returnYears">Number of Years:</label>
  <span class="returnYearsNum">
    ${calculation.years}
  </span><br>

  <p>${calculation}</p>
  <label class="yearColumn"><b>Year</b></label>
  <label class="valueColumn"><b>Value</b></label>
  
  <ul>
    <c:forEach items="${calculation.futureValue}" var="value" varStatus="status">
      <li>${status.count}, ${value}</li>
      </c:forEach>
  </ul>
</span>
<table>
  <tr>
    <th>Year</th>
    <th>Value</th>
  </tr>
  <c:forEach items="${calculation.futureValue}" var="value" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td><elon:currencyFormat /> </td>
    </tr>
  </c:forEach>  

</table>
</form>

<c:import url="/includes/footer.html" />