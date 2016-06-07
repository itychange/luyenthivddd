package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.Bind;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;
import com.lthdl.app.screen.bookdetail.model.BookModel;
import com.lthdl.app.screen.bookdetail.model.BookOverViewModel;
import com.lthdl.app.screen.bookdetail.model.ChapterModel;
import com.lthdl.app.screen.bookdetail.model.SubChapterModel;
import com.lthdl.app.screen.bookdetail.view.BookDetailView;
import com.lthdl.app.screen.bookdetail.view.BookDetailView.BookDetailListener;
import com.lthdl.app.screen.bookdetail.view.BookOverView;
import com.lthdl.app.screen.bookdetail.view.ChapterView;
import com.lthdl.app.screen.bookdetail.view.ChapterView.ChapterViewListener;
import com.lthdl.app.screen.questions.event.OnEventOpenQuestionActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BookDetailContentFragment extends BaseFragment {
    public static final String CLASS_NAME = "BookDetailContentFragment";
    @Bind(R.id.bookDetail)
    BookDetailView bookDetail;
    Handler hd = new Handler() {
        public void handleMessage(Message paramMessage) {
            super.handleMessage(paramMessage);
            BookDetailContentFragment.this.bookDetail.addBookDetailView((View) paramMessage.obj);
        }
    };
    Queue<ChapterModel> queueChapter = new LinkedList<>();

    private void fakeData() {
//        Log.e(Constant.TAG, CLASS_NAME + " fakeData() " + "start");
        BookModel bookModel = new BookModel();
        BookOverViewModel bookOverViewModel = new BookOverViewModel();
        bookOverViewModel.overView = "Giới thiệu nội dung đường lối";
        bookOverViewModel.title = "Đường lối cách mạng";
        bookOverViewModel.author = "Hoàng Cương";
        bookOverViewModel.rateCount = 100;
        bookOverViewModel.status = "Đã mua";
        bookOverViewModel.iconResource = R.drawable.image_book1;
        bookOverViewModel.intro = "It's worth noting that I repeatedly used customTextView in different variants and different places, but it is in no way required that the name of the view match the style or the attribute or anything. Also, this technique should work with any custom view, not just TextViews.";
        bookModel.overView = bookOverViewModel;
        ArrayList localChapterModels = new ArrayList();
        int i = 1;
        while (i < 10) {
//            Log.e(Constant.TAG, CLASS_NAME + " fakeData() " + "i == " + i);
            ChapterModel localChapterModel = new ChapterModel();
            localChapterModel.name = ("Phần " + i + ": Tổng quát phần " + i);
            ArrayList localSubChapterModels = new ArrayList();
            int j = 1;
            while (j < 8) {
//                Log.e(Constant.TAG, CLASS_NAME + " fakeData() " + "j == " + j);
                SubChapterModel localSubChapterModel = new SubChapterModel();
                localSubChapterModel.icon = R.drawable.icon_baikiemtra;
                localSubChapterModel.status = "New";
                localSubChapterModel.type = 0;
                localSubChapterModel.subtitle = ("Đây là sub chapter " + j);
                localSubChapterModel.description = ("Nội dung phụ subChapter " + j);
                localSubChapterModels.add(localSubChapterModel);
                j += 1;
            }
            localChapterModel.subChapterModels = localSubChapterModels;
            localChapterModels.add(localChapterModel);
            this.queueChapter.add(localChapterModel);
            i += 1;
        }
        bookModel.chapterModels = localChapterModels;
        this.bookDetail.setData(bookModel);
        BookOverView bookOverView = new BookOverView(getContext(), bookModel.overView);
        Message msg = new Message();
        msg.obj = bookOverView;
        this.hd.sendMessage(msg);
        addViewThead();
//        Log.e(Constant.TAG, CLASS_NAME + " fakeData() " + " end ");
    }

    void addViewThead() {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (/*(i <= BookDetailContentFragment.this.queueChapter.size()) && */(!BookDetailContentFragment.this.queueChapter.isEmpty())) {
//                    Log.e(Constant.TAG, CLASS_NAME + " addViewThead() " + "i ==" + i);
                    Object localObject = (ChapterModel) BookDetailContentFragment.this.queueChapter.poll();
//                    Log.e(Constant.TAG, CLASS_NAME + " addViewThead() " + " (ChapterModel) localObject.subChapterModels.size() == " + ((ChapterModel) localObject).subChapterModels.size());
                    Message localMessage = new Message();
                    localObject = new ChapterView(BookDetailContentFragment.this.getContext(), (ChapterModel) localObject, i);
                    ((ChapterView) localObject).setChapterViewListener(new ChapterView.ChapterViewListener() {
                        public void onCollapse() {
                        }

                        public void onExpand() {
                        }

                        public void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
                            if (paramInt1 % 2 == 0) {
                                Toast.makeText(paramView.getContext(), "Test giao diện các câu hỏi", Toast.LENGTH_SHORT).show();
                                EventBus.getDefault().post(new OnEventOpenQuestionActivity());
                                return;
                            }
                            EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_SUGGEST_BUY_BOOK));
                        }

                        public void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
                            EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_SETTING));
                        }
                    });
                    localMessage.obj = localObject;
                    BookDetailContentFragment.this.hd.sendMessage(localMessage);
                    i += 1;
                }
                if (BookDetailContentFragment.this.queueChapter.isEmpty()) {
                    return;
                }
            }
        }).start();
    }

    protected void init(View paramView) {
        fakeData();
        this.bookDetail.setBookDetailListener(new BookDetailView.BookDetailListener() {
            public void onCollapse() {
//                Log.e(Constant.TAG, CLASS_NAME + "init()->onCollapse()");
            }

            public void onExpand() {
//                Log.e(Constant.TAG, CLASS_NAME + "init()->onExpand()");
            }

            public void onScollEnd() {
                BookDetailContentFragment.this.addViewThead();
//                Log.e(Constant.TAG, CLASS_NAME + "init()->onScollEnd()");
            }

            public void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
                if (paramInt1 % 2 == 0) {
                    Toast.makeText(paramView.getContext(), "Test giao diện các câu hỏi", Toast.LENGTH_SHORT).show();
                    EventBus.getDefault().post(new OnEventOpenQuestionActivity());
                    return;
                }
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_SUGGEST_BUY_BOOK));
            }

            public void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
//                Log.e(Constant.TAG, CLASS_NAME + "init()->onSubChapterItemSettingClick()");
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_SETTING));
            }
        });
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.book_detail_fragment, paramViewGroup, false);
    }

    public boolean onKeyBack() {
        return super.onKeyBack();
    }
}