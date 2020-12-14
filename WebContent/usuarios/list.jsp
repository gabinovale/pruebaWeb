<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<h1>Usuarios</h1>

<table>
	<thead>
		<tr>
			<th>Nombre de usuario</th>
			<th>Password</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="us">
			<tr>
				<td><c:out value="${us.username}" /></td>
				<td><c:out value="${us.password}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
