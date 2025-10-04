-- 添加缺失的字典类型和数据
-- 用于解决前端请求字典数据时出现的 500 错误

-- 添加字典类型
INSERT INTO sys_dict_type (dict_id, dict_name, dict_type, status, create_by, create_time, remark) VALUES
(11, '认证状态', 'es_is_auth', '0', 'admin', NOW(), '服务主体认证状态列表'),
(12, '组织类型', 'es_org_type', '0', 'admin', NOW(), '服务主体组织类型列表'),
(13, '经营状态', 'es_manage_status', '0', 'admin', NOW(), '服务主体经营状态列表');

-- 添加认证状态字典数据
INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class, is_default, status, create_by, create_time, remark) VALUES
(100, 1, '未认证', '0', 'es_is_auth', '', 'info', 'Y', '0', 'admin', NOW(), '未认证状态'),
(101, 2, '等待审核', '1', 'es_is_auth', '', 'warning', 'N', '0', 'admin', NOW(), '等待审核状态'),
(102, 3, '已认证', '2', 'es_is_auth', '', 'success', 'N', '0', 'admin', NOW(), '已认证状态');

-- 添加组织类型字典数据
INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class, is_default, status, create_by, create_time, remark) VALUES
(103, 1, '合作社', '1', 'es_org_type', '', 'primary', 'Y', '0', 'admin', NOW(), '农业合作社'),
(104, 2, '家庭农场', '2', 'es_org_type', '', 'success', 'N', '0', 'admin', NOW(), '家庭农场'),
(105, 3, '农业企业', '3', 'es_org_type', '', 'info', 'N', '0', 'admin', NOW(), '农业企业'),
(106, 4, '服务公司', '4', 'es_org_type', '', 'warning', 'N', '0', 'admin', NOW(), '农业服务公司'),
(107, 5, '其他', '5', 'es_org_type', '', 'default', 'N', '0', 'admin', NOW(), '其他类型');

-- 添加经营状态字典数据
INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class, is_default, status, create_by, create_time, remark) VALUES
(108, 1, '正常', '1', 'es_manage_status', '', 'success', 'Y', '0', 'admin', NOW(), '正常经营状态'),
(109, 2, '异常', '0', 'es_manage_status', '', 'danger', 'N', '0', 'admin', NOW(), '异常经营状态');


