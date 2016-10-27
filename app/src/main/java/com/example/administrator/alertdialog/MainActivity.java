package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private AlertDialog dialog;
    private  AlertDialog.Builder builder;
    private TextView tv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      tv1 =(TextView) findViewById(R.id.textView1);

        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        Button button3=(Button)this.findViewById(R.id.button3);
        Button button4=(Button)this.findViewById(R.id.button4);
        Button button5=(Button)this.findViewById(R.id.button5);
        Button button6=(Button)this.findViewById(R.id.button6);
        Button button7=(Button)this.findViewById(R.id.button7);

        View.OnClickListener listener=new View.OnClickListener(){
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                case R.id.button7:
                        dialog7();
                        break;

                }
            }
        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);

    }
    private void dialog1() {
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确认退出?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        //创建按键监听
        DialogInterface.OnClickListener list1=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();

                    }  else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list1);
        dialog.show();
    }

    private void dialog2() {
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗?");


        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener list2=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                String str=" ";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface. BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松";
                        break;
                }
               tv1.setText(str);
            }




        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",list2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",list2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",list2);
        dialog.show();

    }
    private void dialog3() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        final EditText tEdit = new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener list3 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+tEdit.getText());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list3);
        dialog.show();
    }
    private void dialog4() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlist=new DialogInterface.OnMultiChoiceClickListener(){
          public void onClick(DialogInterface dialog,int which,boolean isChecked){
              //用一个数组记录下选择得所有选项
bSelect[which]=isChecked;
          }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mlist);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener list4=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
               String str="你选择了";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str= str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list4);
        dialog.show();

    }

    private void dialog5() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
             for(int i=0;i<bSelect.length;i++){
                 if(i!=which){
                     bSelect[i]=false;
                 }else{
                     bSelect[i]=true;
                 }
             }

            }
        };
        builder=new AlertDialog.Builder(this);
    builder.setSingleChoiceItems(item,-1,lis5);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener list5=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which) {
                String str = "你选择了";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                ;
                tv1.setText(str);
            }
            };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list5);
        dialog.show();

    }
    private void dialog6() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                tv1.setText(str);
            }
            };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        dialog=builder.create();
        dialog.setTitle("列表");
        DialogInterface.OnClickListener list6=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which) {
           dialog.dismiss();
            }
            };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",list6);
        dialog.show();
    }
    private void dialog7() {
        LayoutInflater li=getLayoutInflater();
        View layout =li.inflate(R.layout.mylayout,null);
     final EditText et1=(EditText) layout.findViewById(R.id.editText);


        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener list7=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which) {
tv1.setText("输入的是："+et1.getText().toString());

            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",list7);
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",list7);
        dialog.show();
    }
}
