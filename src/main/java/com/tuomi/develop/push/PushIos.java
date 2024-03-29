package com.tuomi.develop.push;

import org.json.JSONArray;
import org.json.JSONObject;

import com.tuomi.develop.push.android.AndroidBroadcast;
import com.tuomi.develop.push.android.AndroidCustomizedcast;
import com.tuomi.develop.push.android.AndroidFilecast;
import com.tuomi.develop.push.android.AndroidGroupcast;
import com.tuomi.develop.push.android.AndroidUnicast;
import com.tuomi.develop.push.ios.IOSBroadcast;
import com.tuomi.develop.push.ios.IOSCustomizedcast;
import com.tuomi.develop.push.ios.IOSFilecast;
import com.tuomi.develop.push.ios.IOSGroupcast;
import com.tuomi.develop.push.ios.IOSUnicast;

import java.util.Map;

public class PushIos {
	private String appkey = "5cf886490cafb2c876000e3f";
	private String appMasterSecret = "9u1rqtmtyogul5nlgw5ovjufsphexfgy";
	private String timestamp = null;
	private PushClient client = new PushClient();

	// 广播
	public void sendAndroidBroadcast() throws Exception {
		AndroidBroadcast broadcast = new AndroidBroadcast(appkey, appMasterSecret);
		broadcast.setTicker("Android broadcast ticker");
		broadcast.setTitle("中文的title");
		broadcast.setText("Android broadcast text");
		broadcast.goAppAfterOpen();
		broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		broadcast.setProductionMode();
		// Set customized fields
		broadcast.setExtraField("test", "helloworld");
		client.send(broadcast);
	}

	// 单发
	public void sendAndroidUnicast(String alias, String title, String msg) throws Exception {
		AndroidUnicast unicast = new AndroidUnicast(appkey, appMasterSecret);
		// TODO Set your device token
		unicast.setDeviceToken(alias);
		unicast.setTicker("Android unicast ticker");
		unicast.setTitle(title);
		unicast.setText(msg);
		unicast.goAppAfterOpen();
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		unicast.setProductionMode();
		// Set customized fields
		unicast.setExtraField("test", "helloworld");
		client.send(unicast);
	}

	public void sendAndroidGroupcast() throws Exception {
		AndroidGroupcast groupcast = new AndroidGroupcast(appkey, appMasterSecret);
		/*
		 * TODO Construct the filter condition: "where": { "and": [ {"tag":"test"},
		 * {"tag":"Test"} ] }
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		JSONObject TestTag = new JSONObject();
		testTag.put("tag", "test");
		TestTag.put("tag", "Test");
		tagArray.put(testTag);
		tagArray.put(TestTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());

		groupcast.setFilter(filterJson);
		groupcast.setTicker("Android groupcast ticker");
		groupcast.setTitle("中文的title");
		groupcast.setText("Android groupcast text");
		groupcast.goAppAfterOpen();
		groupcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		groupcast.setProductionMode();
		client.send(groupcast);
	}

	public void sendAndroidCustomizedcast() throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(appkey, appMasterSecret);
		// TODO Set your alias here, and use comma to split them if there are multiple
		// alias.
		// And if you have many alias, you can also upload a file containing these
		// alias, then
		// use file_id to send customized notification.
		customizedcast.setAlias("alias", "alias_type");
		customizedcast.setTicker("Android customizedcast ticker");
		customizedcast.setTitle("中文的title");
		customizedcast.setText("Android customizedcast text");
		customizedcast.goAppAfterOpen();
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode();
		client.send(customizedcast);
	}

	public void sendAndroidCustomizedcastFile() throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(appkey, appMasterSecret);
		// TODO Set your alias here, and use comma to split them if there are multiple
		// alias.
		// And if you have many alias, you can also upload a file containing these
		// alias, then
		// use file_id to send customized notification.
		String fileId = client.uploadContents(appkey, appMasterSecret, "aa" + "\n" + "bb" + "\n" + "alias");
		customizedcast.setFileId(fileId, "alias_type");
		customizedcast.setTicker("Android customizedcast ticker");
		customizedcast.setTitle("中文的title");
		customizedcast.setText("Android customizedcast text");
		customizedcast.goAppAfterOpen();
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device.
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode();
		client.send(customizedcast);
	}

	public void sendAndroidFilecast() throws Exception {
		AndroidFilecast filecast = new AndroidFilecast(appkey, appMasterSecret);
		// TODO upload your device tokens, and use '\n' to split them if there are
		// multiple tokens
		String fileId = client.uploadContents(appkey, appMasterSecret, "aa" + "\n" + "bb");
		filecast.setFileId(fileId);
		filecast.setTicker("Android filecast ticker");
		filecast.setTitle("中文的title");
		filecast.setText("Android filecast text");
		filecast.goAppAfterOpen();
		filecast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		client.send(filecast);
	}

	//广播
	public void sendIOSBroadcast(String title, String msg) throws Exception {
		IOSBroadcast broadcast = new IOSBroadcast(appkey, appMasterSecret);

		broadcast.setAlert(title);
		broadcast.setBadge(0);
		broadcast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		broadcast.setTestMode();
		// Set customized fields
		broadcast.setCustomizedField(title, msg);
		client.send(broadcast);
	}

	// 单发
	public void sendIOSUnicast(String alias, String title, String manualId , String noticeId) throws Exception {
		IOSUnicast unicast = new IOSUnicast(appkey, appMasterSecret);
		// TODO Set your device token
		unicast.setDeviceToken(alias);
		unicast.setAlert(title);
		unicast.setBadge(0);
		unicast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		unicast.setTestMode();
		// Set customized fields
		unicast.setCustomizedField("id", manualId);
		unicast.setCustomizedField("noticeId", noticeId);
		client.send(unicast);
	}

	// 组播
	public void sendIOSGroupcast() throws Exception {
		IOSGroupcast groupcast = new IOSGroupcast(appkey, appMasterSecret);
		/*
		 * TODO Construct the filter condition: "where": { "and": [ {"tag":"iostest"} ]
		 * }
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		testTag.put("tag", "iostest");
		tagArray.put(testTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());

		// Set filter condition into rootJson
		groupcast.setFilter(filterJson);
		groupcast.setAlert("IOS 组播测试");
		groupcast.setBadge(0);
		groupcast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		groupcast.setTestMode();
		client.send(groupcast);
	}

	public void sendIOSCustomizedcast() throws Exception {
		IOSCustomizedcast customizedcast = new IOSCustomizedcast(appkey, appMasterSecret);
		// TODO Set your alias and alias_type here, and use comma to split them if there
		// are multiple alias.
		// And if you have many alias, you can also upload a file containing these
		// alias, then
		// use file_id to send customized notification.
		customizedcast.setAlias("alias", "alias_type");
		customizedcast.setAlert("IOS 个性化测试");
		customizedcast.setBadge(0);
		customizedcast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		customizedcast.setTestMode();
		client.send(customizedcast);
	}

	public void sendIOSFilecast() throws Exception {
		IOSFilecast filecast = new IOSFilecast(appkey, appMasterSecret);
		// TODO upload your device tokens, and use '\n' to split them if there are
		// multiple tokens
		String fileId = client.uploadContents(appkey, appMasterSecret, "aa" + "\n" + "bb");
		filecast.setFileId(fileId);
		filecast.setAlert("IOS 文件播测试");
		filecast.setBadge(0);
		filecast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		filecast.setTestMode();
		client.send(filecast);
	}

}
