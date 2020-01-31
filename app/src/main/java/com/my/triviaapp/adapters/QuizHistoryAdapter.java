package com.my.triviaapp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.my.triviaapp.R;
import com.my.triviaapp.database.QuizGame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class QuizHistoryAdapter extends RecyclerView.Adapter<QuizHistoryAdapter.ViewHolder> {


    private Context context;
    private List<QuizGame> listItems;

    private ClickListener clickListener;


    public QuizHistoryAdapter(Context context, List<QuizGame> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_history_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuizHistoryAdapter.ViewHolder holder, int position) {

        QuizGame data = listItems.get(position);

        Resources res = context.getResources();

        holder.playerNameTxt.setText("Name : "+data.getContestantName());

        String pattern = "dd MMMM h:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        // ex GAME 1 : date time
        holder.quizGameInfoTxt.setText("GAME "+data.getEntryNumber()+" : "+simpleDateFormat.format(data.getUpdatedAt()));

        String cricketerQuestion = res.getString(R.string.cricketers_question);
        String flagQuestion = res.getString(R.string.flag_question);

        holder.cricketerQuestionTxt.setText(cricketerQuestion);
        holder.cricketerAnswerTxt.setText("Answer : "+data.getFavCricketer());

        holder.flagQuestionTxt.setText(flagQuestion);
        holder.flagAnswerTxt.setText("Answers : "+data.getFlagColors());
    }

    @Override
    public int getItemCount() {
        Log.d("listitemSize", "" + listItems.size());
        return listItems.size();


    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }


public interface ClickListener {
    public void orderClicked(int pos);
}

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView quizCardLayout;
        public TextView quizGameInfoTxt, playerNameTxt, cricketerQuestionTxt, cricketerAnswerTxt,
        flagQuestionTxt, flagAnswerTxt;



        public ViewHolder(final View itemView) {

            super(itemView);


            quizGameInfoTxt = itemView.findViewById(R.id.quiz_game_info_txt);
            playerNameTxt = itemView.findViewById(R.id.contestant_name_txt);

            cricketerQuestionTxt = itemView.findViewById(R.id.quiz_cricketer_question_txt);
            cricketerAnswerTxt = itemView.findViewById(R.id.quiz_cricketer_answer_txt);

            flagQuestionTxt = itemView.findViewById(R.id.quiz_flag_question_txt);
            flagAnswerTxt = itemView.findViewById(R.id.quiz_flag_answer_txt);

        }


    }
}
