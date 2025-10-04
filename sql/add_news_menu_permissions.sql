-- 添加行业资讯菜单权限
-- 首先添加父菜单（行业资讯管理）
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, query, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES ('行业资讯管理', 2000, 4, 'news', 'base/news/index', '', 1, 0, 'M', '0', '0', '', 'news', 'admin', NOW(), '', NULL, '行业资讯管理菜单');

-- 获取刚插入的父菜单ID
SET @parent_menu_id = LAST_INSERT_ID();

-- 添加子菜单权限
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, query, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES 
('行业资讯查询', @parent_menu_id, 1, '', '', '', 1, 0, 'F', '0', '0', 'base:news:query', '#', 'admin', NOW(), '', NULL, ''),
('行业资讯新增', @parent_menu_id, 2, '', '', '', 1, 0, 'F', '0', '0', 'base:news:add', '#', 'admin', NOW(), '', NULL, ''),
('行业资讯修改', @parent_menu_id, 3, '', '', '', 1, 0, 'F', '0', '0', 'base:news:edit', '#', 'admin', NOW(), '', NULL, ''),
('行业资讯删除', @parent_menu_id, 4, '', '', '', 1, 0, 'F', '0', '0', 'base:news:remove', '#', 'admin', NOW(), '', NULL, ''),
('行业资讯导出', @parent_menu_id, 5, '', '', '', 1, 0, 'F', '0', '0', 'base:news:export', '#', 'admin', NOW(), '', NULL, ''),
('行业资讯列表', @parent_menu_id, 6, '', '', '', 1, 0, 'F', '0', '0', 'base:news:list', '#', 'admin', NOW(), '', NULL, '');

-- 为管理员角色分配权限（假设管理员角色ID为1）
INSERT INTO sys_role_menu (role_id, menu_id) 
SELECT 1, menu_id FROM sys_menu WHERE perms LIKE 'base:news:%';

-- 显示添加的菜单
SELECT menu_id, menu_name, parent_id, perms FROM sys_menu WHERE perms LIKE 'base:news:%' ORDER BY menu_id;
