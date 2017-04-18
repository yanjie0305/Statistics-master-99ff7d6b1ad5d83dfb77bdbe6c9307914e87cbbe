package com.edaibu.statistics.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by lyn on 2017/4/14.
 */

public class LoginResp implements Parcelable{


    /**
     * code : 200
     * msg : null
     * data : {"auth_token":null,"access_token":"402881b15b6b4260015b6b42606c0000","member":{"id":"ZGS0016","mobile":"12200002222","password":"6f01701a8bb0e9ddeb8a1ccfae473c6d","realname":"周","companyCode":"ZGS","type":1,"job":"app合伙人","roleCode":"ZGSJS09","status":1,"operator":"ZGS0001","ctime":1492142094000},"city":"北京市","loginPower":[{"url":"/app/bike","name":"车辆"},{"url":"/app/order","name":"订单"},{"url":"/app/fee","name":"车辆租金"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    protected LoginResp(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginResp> CREATOR = new Creator<LoginResp>() {
        @Override
        public LoginResp createFromParcel(Parcel in) {
            return new LoginResp(in);
        }

        @Override
        public LoginResp[] newArray(int size) {
            return new LoginResp[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * auth_token : null
         * access_token : 402881b15b6b4260015b6b42606c0000
         * member : {"id":"ZGS0016","mobile":"12200002222","password":"6f01701a8bb0e9ddeb8a1ccfae473c6d","realname":"周","companyCode":"ZGS","type":1,"job":"app合伙人","roleCode":"ZGSJS09","status":1,"operator":"ZGS0001","ctime":1492142094000}
         * city : 北京市
         * loginPower : [{"url":"/app/bike","name":"车辆"},{"url":"/app/order","name":"订单"},{"url":"/app/fee","name":"车辆租金"}]
         */

        private String auth_token;
        private String access_token;
        private MemberBean member;
        private String city;
        private List<LoginPowerBean> loginPower;

        public String getAuth_token() {
            return auth_token;
        }

        public void setAuth_token(String auth_token) {
            this.auth_token = auth_token;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<LoginPowerBean> getLoginPower() {
            return loginPower;
        }

        public void setLoginPower(List<LoginPowerBean> loginPower) {
            this.loginPower = loginPower;
        }

        public static class MemberBean {
            /**
             * id : ZGS0016
             * mobile : 12200002222
             * password : 6f01701a8bb0e9ddeb8a1ccfae473c6d
             * realname : 周
             * companyCode : ZGS
             * type : 1
             * job : app合伙人
             * roleCode : ZGSJS09
             * status : 1
             * operator : ZGS0001
             * ctime : 1492142094000
             */

            private String id;
            private String mobile;
            private String password;
            private String realname;
            private String companyCode;
            private int type;
            private String job;
            private String roleCode;
            private int status;
            private String operator;
            private long ctime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getCompanyCode() {
                return companyCode;
            }

            public void setCompanyCode(String companyCode) {
                this.companyCode = companyCode;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getRoleCode() {
                return roleCode;
            }

            public void setRoleCode(String roleCode) {
                this.roleCode = roleCode;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }

            public long getCtime() {
                return ctime;
            }

            public void setCtime(long ctime) {
                this.ctime = ctime;
            }
        }

        public static class LoginPowerBean {
            /**
             * url : /app/bike
             * name : 车辆
             */

            private String url;
            private String name;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
