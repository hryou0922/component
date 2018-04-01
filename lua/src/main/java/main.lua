-- 单行注释
--[[
  这是多行注释
  这是多行注释
 --]]
local function main()
  -- 打印信息
  print("Hello World！")
  
  -- if语法:  boolean 类型只有两个可选值：true（真） 和 false（假），Lua 把 false 和 nil 看作是"假"，其他的都为"真":
  if false or nil then
    print("至少有一个是 true")
  else
    print("false 和 nil 都为 false!")
  end
  
  -- ########### 定义字符串 ###################
  -- 定义字符串: 字符串由一对双引号或单引号来表示
  string1 = "this is string1"
  print(string1)
  string2 = 'this is string2'
  print(string2)
  -- 定义字符串: [[]] 来表示一块字符串
  string3 = [[this is string3]]
  print(string3)
  
  -- ########### table（表）###########
  -- 直接初始表
  local tbl2 = {"apple", "pear", "orange", "grape"}
  -- 向列表中新增一个值: 在 Lua 里表的默认初始索引一般以 1 开始
  tbl2[5] = "fruit5" 
  --  Lua 中的表（table）其实是一个"关联数组"（associative arrays），数组的索引可以是数字或者是字符串。
  tbl2['mykey'] = "fruit_mykey" 
  -- 通过pairs读取tabl2值, 在 Lua 里表的默认初始索引一般以 1 开始
  for k, v in pairs(tbl2) do
    print(k .. " : " .. v)
  end
  
  -- ########### Lua while 循环 ########### 
  local a=10
  while( a < 20 )
  do
     print("a 的值为:", a)
     a = a+1
  end
  
  -- ########### for 循环 ########### 
  -- var从exp1变化到exp2，每次变化以exp3为步长递增var，并执行一次"执行体"。exp3是可选的，如果不指定，默认为1
  for i=10,1,-1 do
    print(i)
  end
  -- 通过 ipairs for循环，上面已经有例子，这里略
  
  -- ########### if  ###########
  -- if...else 语句
  --[ 定义全部变量 --]
  a = 10;
  --[ 使用 if 语句 --]
  if( a < 20 )
  then
     --[ if 条件为 true 时打印以下信息 --]
     print("a 小于 20" );
  end
  -- if...elseif...else语句
  
  
end
main()
