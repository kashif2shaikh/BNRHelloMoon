package com.example.kshaikh.hellomoon;


import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HelloMoonVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HelloMoonVideoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private VideoView mVideoView;
    private Button mPlayButton;
    private Button mStopButton;
    private int mCurPos = 1;
    private boolean mPlaying = false;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HelloMoonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HelloMoonVideoFragment newInstance(String param1, String param2) {
        HelloMoonVideoFragment fragment = new HelloMoonVideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HelloMoonVideoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hello_moon_video, container, false);
        mVideoView = (VideoView) v.findViewById(R.id.hellomoon_video_view);
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.apollo_17_stroll_2);
        mVideoView.setVideoURI(uri);

        mVideoView.seekTo(mCurPos);

        if(mPlaying) {
            mVideoView.start();
        }

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_video_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideoView.start();
            }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_video_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideoView.pause();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mVideoView.stopPlayback();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCurPos = mVideoView.getCurrentPosition();
        mPlaying = mVideoView.isPlaying();
    }

}
