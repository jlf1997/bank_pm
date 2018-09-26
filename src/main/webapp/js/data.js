window.onload = selectionInit;
function valueChanged(obj){
			var v = obj.nextElementSibling;
			if(obj.value == 'erp_wage_ckmnlrgzmx' || obj.value == 'erp_wage_dkmnlrgzmx'){
				v.style.display= "inline";
			}else{
				v.style.display= "none";
			}
}

var arr_detail =[
                 ["app_dkkhcpxx","app_mycust","app_sjyhcpxx"],
                 ["erp_bas_zbk","erp_wage_ckkhhsmx","erp_wage_ckmnlrgzmx","erp_wage_dkkhbsmx",
                  "erp_wage_dkmnlrgzmx","erp_wage_dqbcgzmx","erp_wage_etchsgzmx","erp_wage_gljxgzmx",
                  "erp_wage_sjyhhsmx","erp_wage_sjyhjymx","erp_wage_ygjx","erp_wage_ygjx_mx"
                 ],
                 ["hr_bas_organization","hr_bas_post","hr_bas_staff","hr_bas_staff_post"],
                 ["khgxgl_bsdkdqmx","khgxgl_bsdkqxmx","khgxgl_bsdnffdndqshl","khgxgl_bslnffdndqshl",
                  "khgxgl_bsxzbldkmx","khgxgl_ckkhghlsb","khgxgl_ckkhxxgl","khgxgl_ckkhyxdjb",
                  "khgxgl_ckzhghxx","khgxgl_cpxx","khgxgl_dkkhghlsb","khgxgl_dkkhxxgl",
                  "khgxgl_dkkhyxdjb","khgxgl_etccpghlsb","khgxgl_etckhghlsb","khgxgl_etckhgl",
                  "khgxgl_etcyxdjb","khgxgl_khzlgl_glrxx","khgxgl_mbcust","khgxgl_posyxdjb",
                  "khgxgl_sjyhkhghlsb","khgxgl_sjyhsjghlsb","khgxgl_sjyhyxdjb",
                  "khgxgl_tzdqckdqmx","khgxgl_yqdkbsmx"],
                 ["v_wage_blqsmx","v_wage_graljc","v_wage_jgkj","v_wage_jgpj","v_wage_ywlmx"],
                 ["sys_bas_user"]
               ];
function selectionInit(){
	var selections = document.getElementsByName("tableName");
	var len = selections.length;
	for(var i = 0; i < len; i++){
		selections[i].length = arr_detail[0].length;
		for(var j = 0; j < selections[i].length; j++){
			selections[i].options[j].text = arr_detail[0][j];
		}
	}
}
function categoryChanged(obj){
	var selection = obj.nextElementSibling;
	var v = obj.value;
	var index = 0;
	if(v == 'app'){
		//这一句必不可少
		selection.length = arr_detail[0].length;
		index = 0;
	}else if(v == 'erp'){
		selection.length = arr_detail[1].length;
		index = 1;
	}else if(v == 'hr_bas'){
		selection.length = arr_detail[2].length;
		index = 2;
	}else if(v == 'khgxgl'){
		selection.length = arr_detail[3].length;
		index = 3;
	}else if(v == 'v_wage'){
		selection.length = arr_detail[4].length;
		index = 4;
	}else{//sys_bas
		selection.length = arr_detail[5].length;
		index = 5;
	}
	for(var i = 0; i < selection.length; i++){
		selection.options[i].value = arr_detail[index][i];
		selection.options[i].innerHTML = arr_detail[index][i];
	}
}

