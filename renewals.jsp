<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Renewals</title>
</head>
<body>
    <h1>Renewals</h1>
    <form action="/renewals" method="post">
        <input type="text" name="policyId" placeholder="Policy ID">
        <input type="date" name="renewalDate" placeholder="Renewal Date">
        <input type="text" name="newCoverageAmount" placeholder="New Coverage Amount">
        <select name="renewalStatus">
            <option value="PENDING">PENDING</option>
            <option value="APPROVED">APPROVED</option>
            <option value="REJECTED">REJECTED</option>
        </select>
        <button type="submit">Save</button>
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Policy ID</th>
            <th>Renewal Date</th>
            <th>New Coverage Amount</th>
            <th>Status</th>
        </tr>
        <c:forEach var="renewal" items="${renewals}">
            <tr>
                <td>${renewal.renewalId}</td>
                <td>${renewal.policy.policyId}</td>
                <td>${renewal.renewalDate}</td>
                <td>${renewal.newCoverageAmount}</td>
                <td>${renewal.renewalStatus}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>