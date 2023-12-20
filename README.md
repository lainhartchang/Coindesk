# Coindesk
CUB java spring boot api practise

sql create table statement 

**注意事項**
Call API 前請先執行 __/display/coindesk__ API，以取得遠端資料並匯入資料庫。


**Create Table**
CREATE TABLE  IF NOT EXISTS Bitcoin(
    id int NOT NULL PRIMARY KEY,
    code varchar(4)  NOT NULL,
    codecname varchar(4) NOT NULL,
    symbol nvarchar(10) NOT NULL,
    rate varchar(20) NOT NULL,
    description nvarchar(30),
    ratefloat varchar(20) NOT NULL,
    updated varchar(25) NOT NULL,
    updatediso varchar(25) NOT NULL,
    updateduk varchar(20) NOT NULL,
    updatedtw varchar(19) NOT NULL,
    createdate bigint NOT NULL,
    moddate bigint NOT NULL
)

**建立索引**

CREATE INDEX IDX_BITCOIN_1
ON BITCOIN (code)