-- ----------------------------
-- Table structure for [dbo].[SYS_PERMISSION]
-- ----------------------------
DROP TABLE [dbo].[SYS_PERMISSION]
GO
CREATE TABLE [dbo].[SYS_PERMISSION] (
[ID] varchar(72) NOT NULL ,
[PERMISSION_NAME] varchar(510) NOT NULL ,
[PERMISSION_VALUE] varchar(510) NOT NULL
)


GO

-- ----------------------------
-- Records of SYS_PERMISSION
-- ----------------------------
INSERT INTO [dbo].[SYS_PERMISSION] ([ID], [PERMISSION_NAME], [PERMISSION_VALUE]) VALUES (N'0', N'系统管理', N'sys_admin');
GO

-- ----------------------------
-- Table structure for [dbo].[SYS_ROLE]
-- ----------------------------
DROP TABLE [dbo].[SYS_ROLE]
GO
CREATE TABLE [dbo].[SYS_ROLE] (
[ID] varchar(36) NOT NULL ,
[ROLE_NAME] varchar(36) NOT NULL ,
[ORG_ID] varchar(36) NOT NULL ,
[ORG_NAME] varchar(255) NOT NULL ,
[DEPARTMENT_CODE] varchar(36) NOT NULL ,
[DEPARTMENT_NAME] varchar(255) NOT NULL ,
[STATUS] numeric(38) NULL
)


GO

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO [dbo].[SYS_ROLE] ([ID], [ROLE_NAME], [ORG_ID], [ORG_NAME], [DEPARTMENT_CODE], [DEPARTMENT_NAME], [STATUS]) VALUES (N'0', N'系统管理员', N'FF6A4197-F465678A-E04011AC-1D7F07AE', N'东南大学', N'1', N'1', N'1');
GO

-- ----------------------------
-- Table structure for [dbo].[SYS_ROLE_PERMISSION]
-- ----------------------------
DROP TABLE [dbo].[SYS_ROLE_PERMISSION]
GO
CREATE TABLE [dbo].[SYS_ROLE_PERMISSION] (
[PERMISSION_ID] varchar(36) NOT NULL ,
[ROLE_ID] varchar(36) NOT NULL
)


GO

-- ----------------------------
-- Records of SYS_ROLE_PERMISSION
-- ----------------------------
INSERT INTO [dbo].[SYS_ROLE_PERMISSION] ([PERMISSION_ID], [ROLE_ID]) VALUES (N'0', N'0');
GO

-- ----------------------------
-- Table structure for [dbo].[SYS_USER]
-- ----------------------------
DROP TABLE [dbo].[SYS_USER]
GO
CREATE TABLE [dbo].[SYS_USER] (
[ID] varchar(72) NOT NULL ,
[ORG_ID] varchar(72) NULL ,
[ORG_NAME] varchar(200) NULL ,
[EMPLOYEE_ID] varchar(72) NULL ,
[EMPLOYEE_NAME] varchar(100) NULL ,
[LOGIN_NAME] varchar(100) NULL ,
[PASSWORD] varchar(40) NULL ,
[STATUS] numeric(1) NULL
)


GO

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO [dbo].[SYS_USER] ([ID], [ORG_ID], [ORG_NAME], [EMPLOYEE_ID], [EMPLOYEE_NAME], [LOGIN_NAME], [PASSWORD], [STATUS]) VALUES (N'0', N'FF6A4197-F465678A-E04011AC-1D7F07AE', N'东南大学', N'ffeb3cce-faff-4557-9304-95f5c90a18fb', N'系统管理员', N'admin', N'admin', N'1');
GO

-- ----------------------------
-- Table structure for [dbo].[SYS_USER_ROLE]
-- ----------------------------
DROP TABLE [dbo].[SYS_USER_ROLE]
GO
CREATE TABLE [dbo].[SYS_USER_ROLE] (
[LOGIN_NAME] varchar(36) NOT NULL ,
[ROLE_ID] varchar(36) NOT NULL
)


GO

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO [dbo].[SYS_USER_ROLE] ([LOGIN_NAME], [ROLE_ID]) VALUES (N'admin', N'0');
GO
