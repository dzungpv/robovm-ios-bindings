package org.robovm.bindings.ythelper.sample;

import java.util.HashMap;
import java.util.Map;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.NSLayoutAttribute;
import org.robovm.apple.uikit.NSLayoutConstraint;
import org.robovm.apple.uikit.NSLayoutRelation;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIViewAutoresizing;
import org.robovm.apple.uikit.UIViewContentMode;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.bindings.ythelper.YTPlaybackQuality;
import org.robovm.bindings.ythelper.YTPlayerError;
import org.robovm.bindings.ythelper.YTPlayerState;
import org.robovm.bindings.ythelper.YTPlayerView;
import org.robovm.bindings.ythelper.YTPlayerViewDelegate;
import org.robovm.objc.annotation.Method;

public class SingleVideo extends UIViewController implements YTPlayerViewDelegate{
	
	  // For a full list of player parameters, see the documentation for the HTML5 player
	  // at: https://developers.google.com/youtube/player_parameters?playerVersion=HTML5
	YTPlayerView playerView;
	
    @Override
    public void viewDidLoad () {
        setupViews();
    }

	private void setupViews() {
		
//		 NSMutableDictionary<NSString, NSString> playerVars = new NSMutableDictionary<NSString, NSString>();
//		 playerVars.put(new NSString("controls"), new NSString("0"));
//		 playerVars.put(new NSString("playsinline"), new NSString("1"));
//		 playerVars.put(new NSString("autohide"), new NSString("1"));
//		 playerVars.put(new NSString("showinfo"), new NSString("0"));
//		 playerVars.put(new NSString("modestbranding"), new NSString("1"));
		  
		
		     HashMap<NSString, NSString> playerVarsPara = new HashMap<NSString, NSString>();
			 playerVarsPara.put(new NSString("controls"), new NSString("0"));
			 playerVarsPara.put(new NSString("playsinline"), new NSString("1"));
			 playerVarsPara.put(new NSString("autohide"), new NSString("1"));
			 playerVarsPara.put(new NSString("showinfo"), new NSString("0"));
			 playerVarsPara.put(new NSString("modestbranding"), new NSString("1"));
		   
		    NSDictionary<NSString, NSString> playerVars = new NSDictionary<NSString, NSString>(playerVarsPara);

		playerView = new YTPlayerView();
		playerView.setFrame(new CGRect(10, 80, 300, 275));
		playerView.setBackgroundColor(UIColor.green());
		playerView.setContentMode(UIViewContentMode.ScaleAspectFill);
		playerView.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
		playerView.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight);
		playerView.setDelegate(this);
		playerView.setTranslatesAutoresizingMaskIntoConstraints(false);
		
		getView().addSubview(playerView);
		
	    //NSLayoutConstraint myConstraint = new NSLayoutConstraint();
	    //myConstraint.create(playerView, NSLayoutAttribute.CenterY, NSLayoutRelation.Equal, getView(), NSLayoutAttribute.CenterY, 0.5, 0.0);

	    //getView().addConstraint(myConstraint);
	    //getView().removeConstraints(getView().getConstraints());
	    
		//getView().setTranslatesAutoresizingMaskIntoConstraints(true);
		playerView.loadWithVideoId(new NSString("Uv1JkBL5728"), playerVars);
		//playerView.loadWithVideoId(new NSString("Uv1JkBL5728"));
		
		UIButton playBtn = new UIButton(new CGRect(10, 400, 120, 80));
		playBtn.setTitle("Play", UIControlState.Normal);
		playBtn.setBackgroundColor(UIColor.red());
		playBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				playerView.playVideo();			
			}
			});
		
		
		UIButton stopBtn = new UIButton(new CGRect(190, 400, 120, 80));
		stopBtn.setTitle("Stop", UIControlState.Normal);
		stopBtn.setBackgroundColor(UIColor.red());
		stopBtn.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				playerView.stopVideo();				
			}
			});
		playBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
		getView().addSubview(playBtn);
		
		stopBtn.setTranslatesAutoresizingMaskIntoConstraints(false);
		getView().addSubview(stopBtn);
		

		
//		- (void)viewDidLoad
//		{
//		    [super viewDidLoad];
//		    // Do any additional setup after loading the view, typically from a nib.
//
//		    self.myView = [[YTPlayerView alloc] initWithFrame:CGRectMake(10, 80, 300, 275)];
//		    self.myView.backgroundColor = [UIColor lightGrayColor];
//
//		    [self.view addSubview:self.myView];
//
//		    [self.myYoutubePlayer loadWithVideoId:@"Yf5_ZQcP7y0"];
//
//		    self.playBtn = [[UIButton alloc] initWithFrame:CGRectMake(10, 400, 120, 80)];
//		    [self.playBtn setTitle:@"Play" forState:UIControlStateNormal];
//		    self.playBtn.backgroundColor = [UIColor redColor];
//		    [self.playBtn addTarget:self action:@selector(playVideo:) forControlEvents:UIControlEventTouchDown];
//
//		    self.stopBtn = [[UIButton alloc] initWithFrame:CGRectMake(190, 400, 120, 80)];
//		    [self.stopBtn setTitle:@"Stop" forState:UIControlStateNormal];
//		    self.stopBtn.backgroundColor = [UIColor redColor];
//		    [self.stopBtn addTarget:self action:@selector(stopVideo:) forControlEvents:UIControlEventTouchDown];
//
//		    [self.view addSubview:self.playBtn];
//		    [self.view addSubview:self.stopBtn];
//
//		}
	}

	@Override
	public void playerViewDidBecomeReady(YTPlayerView playerView) {
		System.out.println("video ready");
		playerView.playVideo();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlayerState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlaybackQuality quality) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerView(YTPlayerView playerView, YTPlayerError error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerView(YTPlayerView playerView, float playTime) {

	}

	@Override
	public UIColor playerViewPreferredWebViewBackgroundColor(YTPlayerView playerView) {
		return null;
	}

}
