var menu = {
	setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: false,
        root: {
            isRoot: true,
            nodes: []
        }
    },
	loadMenuTree:function(){
		$("#menuTree").zTree(menu.setting, privilegeDate);
	}
};

$().ready(function(){
	menu.loadMenuTree();
});
