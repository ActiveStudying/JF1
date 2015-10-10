package vn.edu.activestudy.activestudy.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.activestudy.activestudy.R;
import vn.edu.activestudy.activestudy.adapter.ChatGroupListAdapter;
import vn.edu.activestudy.activestudy.manager.MessageItemManager;
import vn.edu.activestudy.activestudy.model.MessageItem;

public class ChatGroupActivity extends AppCompatActivity {

    private ListView lvChat;
    private Button btnSend;
    private EditText edtContentMess;
    private ArrayList<MessageItem> mListMessages;
    private ChatGroupListAdapter mChatGroupAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group);
        initUI();
        initData();
        initControl();

    }

    private void initUI() {
        lvChat = (ListView) findViewById(R.id.lvChat);
        btnSend = (Button) findViewById(R.id.btnSendTextChat);
        edtContentMess = (EditText) findViewById(R.id.etContentMessage);
    }

    private void initData() {
        mListMessages = MessageItemManager.getInstance().getListChatGroupList();
        mChatGroupAdapter = new ChatGroupListAdapter(this, R.layout.item_chat_group, mListMessages);
        lvChat.setDivider(null);
        lvChat.setAdapter(mChatGroupAdapter);
    }

    private void initControl() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatGroupListAdapter.isMe = !ChatGroupListAdapter.isMe;
                mListMessages.add(new MessageItem(1, edtContentMess.getText().toString(), ChatGroupListAdapter.isMe + "", ""));
                edtContentMess.setText("");
//                lvChat.scrollList(mListMessages.get(mListMessages.size()-1));
                lvChat.getBackground();
                mChatGroupAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
