package io.bloc.android.blocly.ui.adapter;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.DataSource;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    private static String TAG = ItemAdapter.class.getSimpleName();

    //Override
    public ItemAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_item, viewGroup, false);
        return new ItemAdapterViewHolder(inflate);
    }

    //Override
    public void onBindViewHolder(ItemAdapterViewHolder itemAdapterViewHolder, int index) {
        DataSource sharedDataSource = BloclyApplication.getSharedDataSource();
        itemAdapterViewHolder.update(sharedDataSource.getFeeds().get(0), sharedDataSource.getItems().get(index));
    }

    //Override
    public int getItemCount() {
        return BloclyApplication.getSharedDataSource().getItems().size();
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements ImageLoadingListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        boolean contentExpanded;

        TextView title;
        TextView feed;
        TextView content;

        View headerWrapper;
        ImageView headerImage;

        //String imageURL;
        RssItem rssItem;
        //Background Image

        Throwable logThrowable;

        //String backgroundImageURL;
        //ImageView backgroundImageView ;
        //View backgroundWrapper;

        CheckBox archiveCheckBox;
        CheckBox favoriteCheckBox;

        View expandedContentWrapper;
        TextView expandedContent;
        TextView visitSite;




        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_rss_item_title);
            feed = (TextView) itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = (TextView) itemView.findViewById(R.id.tv_rss_item_content);

            headerWrapper = itemView.findViewById(R.id.fl_rss_item_image_header);
            headerImage = (ImageView) headerWrapper.findViewById(R.id.iv_rss_item_image);
            archiveCheckBox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_check_mark);
            favoriteCheckBox = (CheckBox) itemView.findViewById(R.id.cb_rss_item_favorite_star);

            expandedContentWrapper = itemView.findViewById(R.id.ll_rss_item_expanded_content_wrapper);
            expandedContent = (TextView) itemView.findViewById(R.id.tv_rss_item_content_full);
            visitSite = (TextView) itemView.findViewById(R.id.tv_rss_item_visit_site);

            itemView.setOnClickListener(this);
            archiveCheckBox.setOnCheckedChangeListener(this);
            favoriteCheckBox.setOnCheckedChangeListener(this);
             visitSite.setOnClickListener(this);


//Background Image
            //backgroundWrapper = itemView.findViewById(R.id.iv_rss_background_image);
            //backgroundImageView = (ImageView) backgroundWrapper.findViewById(R.id.iv_rss_background_image);

        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            this.rssItem = rssItem;
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
            expandedContent.setText(rssItem.getDescription());

          //  imageURL =rssItem.getImageUrl();
            //backgroundImageURL=rssFeed.getImageUrl();
           // ImageLoader.getInstance().loadImage(rssFeed.getImageUrl(), this);

           // if(rssFeed.getImageUrl() != null) {
               // backgroundWrapper.setVisibility(View.VISIBLE);
                //backgroundImageView.setVisibility(View.INVISIBLE);
                // ImageLoader.getInstance().loadImage(imageURL, this);
               // ImageLoader.getInstance().loadImage(rssFeed.getImageUrl(), this);
           // }else{
             //   backgroundWrapper.setVisibility(View.GONE);

            //}

            //Log.e(TAG,"Background Image ItemAdapterViewHolder.update for URL: "+backgroundImageURL);
           // Log.e(TAG,"ItemAdapterViewHolder.update for URL: "+rssItem.getImageUrl());

           // if(imageURL != null) {

           if(rssItem.getImageUrl() != null) {
                headerWrapper.setVisibility(View.VISIBLE);
                headerImage.setVisibility(View.INVISIBLE);
               // ImageLoader.getInstance().loadImage(imageURL, this);
               ImageLoader.getInstance().loadImage(rssItem.getImageUrl(), this);
            }else{
                headerWrapper.setVisibility(View.GONE);

            }
        }

        //override
        public void onLoadingStarted(String imageUri, View view){
            Log.e(TAG,"onLoadingStarted for URL: "+imageUri);
          // Log.i(TAG, "onLoadingStarted for URL: " + imageUri, new Throwable().fillInStackTrace());
        }

        //override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason){
            Log.e(TAG,"onLoadingFailed: "+failReason.toString()+" for URL: "+imageUri);
        }

        //override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage){
            if (imageUri.equals(rssItem.getImageUrl())) {
                headerImage.setImageBitmap(loadedImage);
                headerImage.setVisibility(View.VISIBLE);
            }
        }

        //override
        public void onLoadingCancelled(String imageUri, View view) {

            ImageLoader.getInstance().loadImage(imageUri, this);
        }

        public void onClick(View view){

            //final TransitionDrawable background = (TransitionDrawable) itemView.getBackground();
            //background.startTransition(30);
            Toast.makeText(view.getContext(),rssItem.getTitle(),Toast.LENGTH_SHORT).show();

            if (view == itemView){
                contentExpanded = !contentExpanded;
                expandedContentWrapper.setVisibility(contentExpanded ? View.VISIBLE : View.GONE);
                content.setVisibility(contentExpanded ? View.GONE : View.VISIBLE);
                animateContent(!contentExpanded);
            }
            else {
                Toast.makeText(view.getContext(), "Visit " + rssItem.getUrl(),Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.cb_rss_item_check_mark ){

                Log.v(TAG, "button view checked changed to: " + isChecked);
            }
            else{
                Log.v(TAG, "star view checked changed to: " + isChecked);
            }

        }


        private void animateContent(final boolean expand) {
            if ((expand && contentExpanded) || (!expand && !contentExpanded)) {
                Log.v(TAG, "returning ");
                return;
            }
            int startingHeight = expandedContentWrapper.getMeasuredHeight();
            int finalHeight = content.getMeasuredHeight();

            if (expand) {
                startingHeight = finalHeight;
                expandedContentWrapper.setAlpha(0f);
                expandedContentWrapper.setVisibility(View.VISIBLE);

                expandedContentWrapper.measure(
                        View.MeasureSpec.makeMeasureSpec(content.getWidth(), View.MeasureSpec.EXACTLY),
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                finalHeight = expandedContentWrapper.getMeasuredHeight();
            } else {

                content.setVisibility(View.VISIBLE);
            }

            startAnimator(startingHeight, finalHeight, new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {

                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float wrapperAlpha = expand ? animatedFraction : 1f - animatedFraction;
                    float contentAlpha = 1f - wrapperAlpha;

                    expandedContentWrapper.getLayoutParams().height = animatedFraction == 1f ?
                            ViewGroup.LayoutParams.WRAP_CONTENT :
                            (Integer) valueAnimator.getAnimatedValue();

                    expandedContentWrapper.requestLayout();
                    if (animatedFraction == 1) {
                        if (expand) {
                            content.setVisibility(View.GONE);
                        } else {
                            expandedContentWrapper.setVisibility(View.GONE);
                        }

                    }
                }

                });
                contentExpanded = expand;
            }

        private void startAnimator(int start,int end, ValueAnimator.AnimatorUpdateListener animatorUpdateListener){

            ValueAnimator valueAnimator = ValueAnimator.ofInt(start,end);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.setDuration((itemView.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.start();

        }

        }

    }


