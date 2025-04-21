<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Policies</title>
</head>
<body>
    <h1>Policies</h1>
    <form action="/policies" method="post">
        <input type="text" name="policyNumber" placeholder="Policy Number">
        <input type="text" name="businessId" placeholder="Business ID">
        <input type="text" name="coverageAmount" placeholder="Coverage Amount">
        <input type="date" name="policyStartDate" placeholder="Policy Start Date">
        <input type="date" name="policyEndDate" placeholder="Policy End Date">
        <select name="policyStatus">
            <option value="ACTIVE">ACTIVE</option>
            <option value="INACTIVE">INACTIVE</option>
            <option value="RENEWED">RENEWED</option>
        </select>
        <button type="submit">Save</button>
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Policy Number</th>
            <th>Business ID</th>
            <th>Coverage Amount</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="policy" items="${policies}">
            <tr>
                <td>${policy.policyId}</td>
                <td>${policy.policyNumber}</td>
                <td>${policy.businessId}</td>
                <td>${policy.coverageAmount}</td>
                <td>${policy.policyStartDate}</td>
                <td>${policy.policyEndDate}</td>
                <td>${policy.policyStatus}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>