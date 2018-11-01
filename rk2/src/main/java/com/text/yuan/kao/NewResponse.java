package com.text.yuan.kao;

import java.util.ArrayList;

/**
 * date:2018/11/01
 * author:袁明磊(123)
 * function:
 */
class NewResponse {

        String code;
        String msg;
        ArrayList<NewItemBean> data;

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        public ArrayList<NewItemBean> getData() {
            return data;
        }

        class NewItemBean{
            String img;
            String title;

            public String getImg() {
                return img;
            }

            public String getTitle() {
                return title;
            }
        }
}


