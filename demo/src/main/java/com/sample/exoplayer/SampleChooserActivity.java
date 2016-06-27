package com.sample.exoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

import com.google.android.exoplayer.demo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SampleChooserActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sample_chooser_activity);
    final List<SampleGroup> sampleGroups = new ArrayList<>();
    SampleGroup  group = new SampleGroup("HLS");
    group.addAll(SampleVideos.HLS);
    sampleGroups.add(group);
    group = new SampleGroup("Others");
    group.addAll(SampleVideos.MISC);
    sampleGroups.add(group);
    ExpandableListView sampleList = (ExpandableListView) findViewById(R.id.sample_list);
    sampleList.setAdapter(new SampleAdapter(this, sampleGroups));
    sampleList.setOnChildClickListener(new OnChildClickListener() {
      @Override
      public boolean onChildClick(ExpandableListView parent, View view, int groupPosition,
          int childPosition, long id) {
        onSampleSelected(sampleGroups.get(groupPosition).samples.get(childPosition));
        return true;
      }
    });
  }

  private void onSampleSelected(SampleVideos.Sample sample) {
    Intent mpdIntent = new Intent(this, VideoPlayerActivity.class)
        .setData(Uri.parse(sample.uri))
        .putExtra(VideoPlayerActivity.CONTENT_ID_EXTRA, sample.contentId)
        .putExtra(VideoPlayerActivity.CONTENT_TYPE_EXTRA, sample.type)
        .putExtra(VideoPlayerActivity.PROVIDER_EXTRA, sample.provider);
    startActivity(mpdIntent);
  }

  private static final class SampleAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<SampleGroup> sampleGroups;

    public SampleAdapter(Context context, List<SampleGroup> sampleGroups) {
      this.context = context;
      this.sampleGroups = sampleGroups;
    }

    @Override
    public SampleVideos.Sample getChild(int groupPosition, int childPosition) {
      return getGroup(groupPosition).samples.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
      return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
        View convertView, ViewGroup parent) {
      View view = convertView;
      if (view == null) {
        view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent,
            false);
      }
      ((TextView) view).setText(getChild(groupPosition, childPosition).name);
      return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
      return getGroup(groupPosition).samples.size();
    }

    @Override
    public SampleGroup getGroup(int groupPosition) {
      return sampleGroups.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
      return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
        ViewGroup parent) {
      View view = convertView;
      if (view == null) {
        view = LayoutInflater.from(context).inflate(R.layout.sample_chooser_inline_header, parent,
            false);
      }
      ((TextView) view).setText(getGroup(groupPosition).title);
      return view;
    }

    @Override
    public int getGroupCount() {
      return sampleGroups.size();
    }

    @Override
    public boolean hasStableIds() {
      return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
      return true;
    }

  }

  private static final class SampleGroup {

    public final String title;
    public final List<SampleVideos.Sample> samples;

    public SampleGroup(String title) {
      this.title = title;
      this.samples = new ArrayList<>();
    }

    public void addAll(SampleVideos.Sample[] samples) {
      Collections.addAll(this.samples, samples);
    }

  }

}
