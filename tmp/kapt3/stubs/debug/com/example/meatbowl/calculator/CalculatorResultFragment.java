package com.example.meatbowl.calculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u009e\u0001\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/example/meatbowl/calculator/CalculatorResultFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activeType", "", "getActiveType", "()Ljava/lang/String;", "setActiveType", "(Ljava/lang/String;)V", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "getDatabase", "()Lcom/google/firebase/database/FirebaseDatabase;", "database$delegate", "Lkotlin/Lazy;", "endDate", "Ljava/time/LocalDate;", "getEndDate", "()Ljava/time/LocalDate;", "setEndDate", "(Ljava/time/LocalDate;)V", "termType", "getTermType", "setTermType", "userRef", "Lcom/google/firebase/database/DatabaseReference;", "user_diet", "SettingNewDietData", "", "userId", "petName", "totalTerm", "totalAmount", "mmAmount", "ebAmount", "orAmount", "plantAmount", "mmName", "ebName", "orName", "vgName", "frName", "otName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
public final class CalculatorResultFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy database$delegate = null;
    private final com.google.firebase.database.DatabaseReference user_diet = null;
    private final com.google.firebase.database.DatabaseReference userRef = null;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate endDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String termType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String activeType;
    private java.util.HashMap _$_findViewCache;
    
    private final com.google.firebase.database.FirebaseDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getEndDate() {
        return null;
    }
    
    public final void setEndDate(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTermType() {
        return null;
    }
    
    public final void setTermType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActiveType() {
        return null;
    }
    
    public final void setActiveType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void SettingNewDietData(java.lang.String userId, java.lang.String petName, java.lang.String totalTerm, java.lang.String activeType, java.lang.String totalAmount, java.lang.String mmAmount, java.lang.String ebAmount, java.lang.String orAmount, java.lang.String plantAmount, java.lang.String mmName, java.lang.String ebName, java.lang.String orName, java.lang.String vgName, java.lang.String frName, java.lang.String otName) {
    }
    
    public CalculatorResultFragment() {
        super();
    }
}