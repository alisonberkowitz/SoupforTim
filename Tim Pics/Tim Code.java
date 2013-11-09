//<!-- Animation frames are wheel0.png -- wheel5.png files inside the
//res/drawable/ folder -->

//Make this a new XML called spin_animation.xml
 <animation-list android:id="@+id/selected" android:oneshot="false">
    <item android:drawable="@drawable/Tim1" android:duration="50" />
    <item android:drawable="@drawable/Tim2" android:duration="50" />
    <item android:drawable="@drawable/Tim3" android:duration="50" />
    <item android:drawable="@drawable/Tim4" android:duration="50" />
    <item android:drawable="@drawable/Tim5" android:duration="50" />
    <item android:drawable="@drawable/Tim6" android:duration="50" />
    <item android:drawable="@drawable/Tim7" android:duration="50" />
    <item android:drawable="@drawable/Tim8" android:duration="50" />
    <item android:drawable="@drawable/Tim9" android:duration="50" />
 </animation-list>

// Load the ImageView that will host the animation and
 // set its background to our AnimationDrawable XML resource.
 ImageView img = (ImageView)findViewById(R.id.spinning_wheel_image);
 img.setBackgroundResource(R.drawable.spin_animation);

 // Get the background, which has been compiled to an AnimationDrawable object.
 AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

 // Start the animation (looped playback by default).
 frameAnimation.start();