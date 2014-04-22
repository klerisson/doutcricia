package br.ufu.facom.lsi.service;

public interface FacebookService {
	
	public void getFriendList(SocialContext socialContext);
	public void getFbProfile(SocialContext socialContext);
	public void postPhotoAndTaggAllFriends(String accessToken);
	
}
