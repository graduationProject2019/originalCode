package com.example.meatbowl.news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/example/meatbowl/news/WriteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bgList", "", "", "getBgList", "()Ljava/util/List;", "currentBgPosition", "", "getCurrentBgPosition", "()I", "setCurrentBgPosition", "(I)V", "mode", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "postId", "getPostId", "setPostId", "getMyId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "MyAdapter", "MyViewHolder", "app_debug"})
public final class WriteActivity extends androidx.appcompat.app.AppCompatActivity {
    private int currentBgPosition;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mode;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String postId;
    
    /**
     * * 배경 리스트 데이터
     *     * res/drawable 디렉토리에 있는 배경 이미지를 uri 주소로 사용한다.
     *     * uri 주소로 사용하면 추후 웹에 있는 이미지 URL 도 바로 사용이 가능하다.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> bgList = null;
    private java.util.HashMap _$_findViewCache;
    
    public final int getCurrentBgPosition() {
        return 0;
    }
    
    public final void setCurrentBgPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMode() {
        return null;
    }
    
    public final void setMode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPostId() {
        return null;
    }
    
    public final void setPostId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBgList() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * * 디바이스의 ID 를 반환하는 메소드
     *     * 글쓴 사람의 ID 를 인식합니다.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMyId() {
        return null;
    }
    
    public WriteActivity() {
        super();
    }
    
    /**
     * * RecyclerView 에서 사용하는 View 홀더 클래스
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/meatbowl/news/WriteActivity$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/meatbowl/news/WriteActivity;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImageView", "()Landroid/widget/ImageView;", "app_debug"})
    public final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView imageView = null;
        
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    /**
     * * RecyclerView 의 어댑터 클래스
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/example/meatbowl/news/WriteActivity$MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/meatbowl/news/WriteActivity$MyViewHolder;", "Lcom/example/meatbowl/news/WriteActivity;", "(Lcom/example/meatbowl/news/WriteActivity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    public final class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.meatbowl.news.WriteActivity.MyViewHolder> {
        
        /**
         * * RecyclerView 에서 각 Row(행)에서 그릴 ViewHolder 를 생성할때 불리는 메소드
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.meatbowl.news.WriteActivity.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        /**
         * * RecyclerView 에서 몇개의 행을 그릴지 기준이 되는 메소드
         */
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        /**
         * * 각 행의 포지션에서 그려야할 ViewHolder UI 에 데이터를 적용하는 메소드
         */
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.meatbowl.news.WriteActivity.MyViewHolder holder, int position) {
        }
        
        public MyAdapter() {
            super();
        }
    }
}