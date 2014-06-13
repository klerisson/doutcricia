<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Sign In</title>
<link rel="icon" href="/static/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon" />

</head>
<body>
	<p>Sincronizando acesso ao Facebook...</p>
	<form action="<c:url value="/signin/facebook" />" method="POST"
		id="formFacebook" name="formFacebook" style="display: none">
		<button type="submit">Sign in with Facebook</button>
		<input type="hidden" name="scope"
			value="basic_info,email,user_about_me,friends_about_me,user_activities,friends_activities,user_birthday,friends_birthday,
		    user_education_history,friends_education_history,user_groups,friends_groups,user_hometown,friends_hometown,user_likes,friends_likes,user_location,friends_location,user_photos,friends_photos,
		    user_relationships,friends_relationships,user_religion_politics,friends_religion_politics,user_status,friends_status,user_videos,friends_videos,user_work_history,friends_work_history,
		    offline_access,read_stream,user_actions.video" />
	</form>
	<script type="text/javascript">
		document.formFacebook.submit();
	</script>
</body>
</html>
