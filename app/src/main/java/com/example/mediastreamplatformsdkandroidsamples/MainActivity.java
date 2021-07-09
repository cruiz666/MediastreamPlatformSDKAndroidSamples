package com.example.mediastreamplatformsdkandroidsamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.exoplayer2.ui.PlayerView;

import org.json.JSONObject;

import am.mediastre.mediastreamplatformsdkandroid.MediastreamMiniPlayerConfig;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayer;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerCallback;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerConfig;
import am.mediastre.mediastreamplatformsdkandroid.MediastreamPlayerService;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private PlayerView playerView;
    private MediastreamPlayer player;
    private MediastreamMiniPlayerConfig miniPlayerConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String accountID = "55117baedc01616019533551";
        String vodID = "5eea2dc5a7fc9f0753de12b0";
        String liveID = "5ddfef39d0ff235bffface57";

        // ===== HOW TO PLAY VOD ===== //
        MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.accountID = accountID;
        config.id = vodID;
        config.type = MediastreamPlayerConfig.VideoTypes.VOD;
        // =========================== //

        // ===== HOW TO PLAY LIVE ===== //
        /*MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.accountID = accountID;
        config.id = liveID;
        config.type = MediastreamPlayerConfig.VideoTypes.LIVE;*/
        /**If you want to test the dvr function, uncomment the following two lines,
          what it does is activate the dvr functionality, and tell the player how much
          the retention window will be, its value is in seconds.**/
        /*config.dvr = true;
        config.windowDvr = 3600;*/
        // =========================== //

        /**If your content is setup with access token, you need to send the next line**/
        //config.accessToken = "YOUR TOKEN";

        /**If your content has DRM protection, send the headers like this**/
        // ===== DRM ===== //
        /*config.videoFormat = MediastreamPlayerConfig.AudioVideoFormat.DASH;
        String[] drmHeaders = new String[]{"X-AxDRM-Message", "YOUR DRM TOKEN HERE"};
        config.drmData = new MediastreamPlayerConfig.DrmData("https://drm-widevine-licensing.axprod.net/AcquireLicense", drmHeaders);*/
        // =============== //

        playerView = findViewById(R.id.player_view);
        container = findViewById(R.id.main_media_frame);
        player = new MediastreamPlayer(this, config, container, playerView);

        // You can listen player callbacks too
        /*player.addPlayerCallback(new MediastreamPlayerCallback() {
            @Override
            public void onPlay() {
                System.out.println("MEDIASTREAM PLAYER PLAY");
            }

            @Override
            public void onPause() {
                System.out.println("MEDIASTREAM PLAYER PAUSE");
            }

            @Override
            public void onReady() {
                System.out.println("MEDIASTREAM PLAYER READY");
            }

            @Override
            public void onEnd() {
                System.out.println("MEDIASTREAM PLAYER CONTENT END");
                //You can use this event to load new source
                MediastreamPlayerConfig config2 = new MediastreamPlayerConfig();
                config2.accountID = accountID;
                config2.id = "5ebc7a08fdbffb09adc33765";
                config2.type = MediastreamPlayerConfig.VideoTypes.VOD;
                player.reloadPlayer(config2);
            }

            @Override
            public void onBuffering() {

            }

            @Override
            public void onError(String error) {
                System.out.println("MEDIASTREAM PLAYER ERROR: " + error);
            }

            @Override
            public void onNext() {
                //AVAILABLE FOR AUDIO SOURCES
                System.out.println("MEDIASTREAM PLAYER NEXT BUTTON CLICKED");
            }

            @Override
            public void onPrevious() {
                //AVAILABLE FOR AUDIO SOURCES
                System.out.println("MEDIASTREAM PLAYER PREVIOUS BUTTON CLICKED");
            }

            @Override
            public void onFullscreen() {
                System.out.println("MEDIASTREAM PLAYER ENTER FULLSCREEN");
            }

            @Override
            public void offFullscreen() {
                System.out.println("MEDIASTREAM PLAYER OUT FULLSCREEN");
            }

            @Override
            public void onNewSourceAdded() {
                System.out.println("MEDIASTREAM PLAYER NEW CONTENT ADDED");
            }

            @Override
            public void onLocalSourceAdded() {
                System.out.println("MEDIASTREAM PLAYER NEW LOCAL CONTENT ADDED");
            }

            @Override
            public void onAdPlay() {
                System.out.println("MEDIASTREAM PLAYER PLAYING AD");
            }

            @Override
            public void onAdPause() {
                System.out.println("MEDIASTREAM PLAYER PAUSE AD");
            }

            @Override
            public void onAdLoaded() {
                System.out.println("MEDIASTREAM PLAYER ADS LOADED");
            }

            @Override
            public void onAdResume() {
                System.out.println("MEDIASTREAM PLAYER ADS RESUME");
            }

            @Override
            public void onAdEnded() {
                System.out.println("MEDIASTREAM PLAYER ADS END");
            }

            @Override
            public void onAdError() {
                System.out.println("MEDIASTREAM PLAYER ADS ERROR");
            }

            @Override
            public void onAdBuffering() {

            }

            @Override
            public void onConfigChange(MediastreamMiniPlayerConfig config) {
                System.out.println("MEDIASTREAM PLAYER CONFIG CHANGE");
            }

            @Override
            public void onCastAvailable(Boolean state) {
                System.out.println("MEDIASTREAM PLAYER CONFIG CHANGE");
            }

            @Override
            public void onCastSessionStarting() {
                //coming soon
            }

            @Override
            public void onCastSessionStarted() {
                //coming soon
            }

            @Override
            public void onCastSessionStartFailed() {
                //coming soon
            }

            @Override
            public void onCastSessionEnding() {
                //coming soon
            }

            @Override
            public void onCastSessionEnded() {
                //coming soon
            }

            @Override
            public void onCastSessionResuming() {
                //coming soon
            }

            @Override
            public void onCastSessionResumed() {
                //coming soon
            }

            @Override
            public void onCastSessionResumeFailed() {
                //coming soon
            }

            @Override
            public void onCastSessionSuspended() {
                //coming soon
            }

            @Override
            public void onPlaybackErrors(JSONObject error) {

            }
        });*/

        // How to play audio as service
        /*MediastreamPlayerConfig config = new MediastreamPlayerConfig();
        config.id = liveID;
        config.accountID = accountID;
        config.type = MediastreamPlayerConfig.VideoTypes.LIVE;
        container = findViewById(R.id.main_media_frame);
        startService(config);*/
    }

    void startService(MediastreamPlayerConfig config) {
        playerView = findViewById(R.id.player_view);
        miniPlayerConfig = new MediastreamMiniPlayerConfig();
        MediastreamPlayerCallback cb =  new MediastreamPlayerCallback() {
            @Override
            public void onPlay() {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onReady() {

            }

            @Override
            public void onEnd() {

            }

            @Override
            public void onBuffering() {

            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onNext() {

            }

            @Override
            public void onPrevious() {

            }

            @Override
            public void onFullscreen() {

            }

            @Override
            public void offFullscreen() {

            }

            @Override
            public void onNewSourceAdded() {

            }

            @Override
            public void onLocalSourceAdded() {

            }

            @Override
            public void onAdPlay() {

            }

            @Override
            public void onAdPause() {

            }

            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdResume() {

            }

            @Override
            public void onAdEnded() {

            }

            @Override
            public void onAdError() {

            }

            @Override
            public void onAdBuffering() {

            }

            @Override
            public void onConfigChange(MediastreamMiniPlayerConfig config) {

            }

            @Override
            public void onCastAvailable(Boolean state) {

            }

            @Override
            public void onCastSessionStarting() {

            }

            @Override
            public void onCastSessionStarted() {

            }

            @Override
            public void onCastSessionStartFailed() {

            }

            @Override
            public void onCastSessionEnding() {

            }

            @Override
            public void onCastSessionEnded() {

            }

            @Override
            public void onCastSessionResuming() {

            }

            @Override
            public void onCastSessionResumed() {

            }

            @Override
            public void onCastSessionResumeFailed() {

            }

            @Override
            public void onCastSessionSuspended() {

            }

            @Override
            public void onPlaybackErrors(JSONObject error) {

            }
        };
        MediastreamPlayerService.setupService(this, config, container, playerView, miniPlayerConfig, false, "", cb);
        Intent serviceIntent = new Intent(this, MediastreamPlayerService.class);
        serviceIntent.setAction(getPackageName()+".action.startforeground");
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    @Override
    public void onBackPressed() {
        player.releasePlayer();
    }
}
