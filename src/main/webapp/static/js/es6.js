/**
 * Created by Lindont on 2017/12/16.
 * ES6 语法
 */
"use strict";

//定义方法
var fn = () => {
    console.log("Hello ES6");
};

fn();


//定义箭头函数
let huazn = (a, b) => {
    return `${a}   ${b}`;
};
console.log(huazn('apple', 'banana'));


//定义类
class student {
    hello() {
        console.log('黄浩新很帅很帅');
    }
}
var s = new student();
s.hello();


//定义类与构造方法,静态方法,get,set方法
class poo {
    constructor(value) {
        this.value = value;
        this.dish = [];
    }

    show() {
        console.log(this.value);
    }

    static tre() {
        console.log('Im` 静态方法');
    }

    get menu() {
        return this.dish;
    }

    set menu(dish) {
        this.dish.push(dish);
    }
}
let hao = new poo('我是poo类');
hao.show();
poo.tre();
console.log(hao.menu = 'apple');
console.log(hao.menu = 'lem');
console.log(hao.menu);


//继承与调用父类构造方法,方法
class loo extends poo {
    constructor(value) {
        super(value);
    }
}
let pood = new loo('Im` loo');
pood.show();


//定义一个块级作用域变量
{
    let shuai = '黄浩新';
    console.log(shuai);
}


//对象的属性和方法的简写
var name = "zhangsan";
var password = "123456";
var obj = {
    name,
    password,
    arr: [1, 2, 3, 4],
    sayName(){
        console.log(this.name);
    }
};
console.log(obj);
obj.sayName();


//定义常量
const weather = 'rain';
console.log(weather);

//定义常量数组
const fruit = [];
fruit.push('🍎', '🍋');
console.log(fruit);


//解构数组
console.log('【解构数组】');
function breakfast() {
    return ['🎂', '🍎', '🍋'];
}
let [data1, data2, data3] = breakfast();
console.log(data1, data2, data3);


//解构对象
console.log('【解构对象】');
function breakfast2() {
    return {dessert: data1, drink: data2, teamy: data3};
}
//a,b,c是自己可定义的对象的名字
let {dessert: a, drink: b, teamy: c} = breakfast2();
console.log(a, b, c);


//带标签的模版字符串
console.log('【带标签的模版字符串】');
let des = '🎂', apple = '🍎';
//kitchen为标签
let eat = kitchen`我想吃 ${des} 和 ${apple} !`;
function kitchen(strings, ...values) {
    console.log(strings);
    console.log(values);
}


//查找字符串里的值
console.log('【查找字符串里的值】');
let abc = "123456";
console.log(
    abc.startsWith('1'),
    abc.includes('3'),
    abc.endsWith('6')
);



//默认参数的方法
console.log('【默认参数的方法】');
function defauleparams(str1 = 'opt1', str2 = 'opt2') {
    return `${str1} , ${str2}`;
}
console.log(defauleparams());


//展开操作符
console.log('【展开操作符】');
let cvo = ['1', '2', '3'],
    moa = [...cvo, '4', '5', '6'];
console.log(...cvo);
console.log(...moa);


//Object.is
//对比两个值是否相等
{
    let a = '123', b = '123';
    console.log(Object.is(a, b));
}


//Object.assign
//拷贝或合并对象的值, 语法: Object.assign(target, ...sources)
//(合并)
{
    var target = {a: 1, b: 1};
    var source1 = {b: 2, c: 2};
    var source2 = {c: 3};
    var result = Object.assign(target, source1, source2);   // {a:1, b:2, c:3}
    console.log(result)
}

//(拷贝)
{
    var result = Object.assign({}, {abcc: '🍎'});
    console.log(result);
}


//Object.setPrototypeOf
{
    let breakfast = {
        getDrink(){
            return 'tea';
        }
    };

    let dinner = {
        getDrink(){
            return 'bee';
        }
    };

    let sunday = Object.create(breakfast);
    console.log(sunday.getDrink());
    console.log(Object.getPrototypeOf(sunday) === breakfast);


    Object.setPrototypeOf(sunday, dinner);
    console.log(sunday.getDrink());
    console.log(Object.getPrototypeOf(sunday) === dinner);
}


//__proto__
{
    let breakfast = {
        getDrink(){
            return 'tea';
        }
    };

    let dinner = {
        getDrink(){
            return 'bee';
        }
    };

    let sunday = {
        __proto__: breakfast
    };

    console.log(sunday.getDrink());
    console.log(Object.getPrototypeOf(sunday) === breakfast);

    sunday.__proto__ = breakfast;

    console.log(sunday.getDrink());
    console.log(Object.getPrototypeOf(sunday) === dinner);
}


//super
{
    let breakfast = {
        getDrink(){
            return 'tea...';
        }
    };

    let dinner = {
        getDrink(){
            return 'bee...';
        }
    };

    let sunday = {
        __proto__: breakfast,
        getDrink(){
            return super.getDrink() + 'milk';
        }
    };

    console.log(sunday.getDrink());
}


//Set
{
    let desserts = new Set('abc');
    desserts.add('d');
    desserts.add('a');
    console.log(desserts);
    console.log(desserts.size);
    console.log(desserts.has('d'));

    desserts.delete('b');
    console.log(desserts);

    desserts.forEach(value => {
        console.log(value);
});

    //清空数据
    //desserts.clear();
    //console.log(desserts);
}


//Map
{
    let map = new Map();
    let s = {};
    let f = function () {
        console.log('f')
    };

    map.set('a', 'apple');
    map.set('b', 'banana');
    map.set(s, 'sola');
    map.set(f, 'func');
    console.log(map);
    console.log(map.size);
    console.log(map.get(s));
    console.log(map.get(f));
    map.delete(f);
    console.log(map.has(f));

    map.forEach((value, key) => {
        console.log(`${key} = ${value}`);
});

    //清空数据
    map.clear();
}