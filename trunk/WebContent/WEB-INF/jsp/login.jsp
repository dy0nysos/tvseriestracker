<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="htmlParts/header.jsp" %>
<div class="panel panel-default">
	<div class="panel-heading">
		Se connecter
	</div>
	<div class="panel-body">
		<form class="form" method="post">
			<div class="form-group">
				<label for="username">Utilisateur&nbsp;:&nbsp;</label>
				<input class="form-control" type="text" name="username" id="username"/><br />
			</div>
			<div class="form-group">
				<label for="password">Mot de passe&nbsp;:&nbsp;</label>
				<input class="form-control" type="password" name="password" id="password"/>
			</div>
			  <button type="submit" class="btn btn-default">Me connecter</button>
		</form>
		<c:if test="${not empty password && not empty userName }">
		 thx for submission
		</c:if>
	</div>
</div>
<%@include file="htmlParts/footer.jsp" %>