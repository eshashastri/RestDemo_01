package com.hsbc.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {

        Date date;
        int code;
        String status;
        String message;
        public ErrorResponse(HttpStatus status, String message) {
            this.date = new Date();
            this.code = status.value();
            this.status = status.name();
            this.message = message;
        }
        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        @Override
        public String toString() {
            return "ErrorResponse [date=" + date + ", code=" + code + ", status=" + status + ", message=" + message + "]";
        }
}
