class Alert {     
    static get() {
        if(!this.instance) {
            this.instance = new this();
        }
        return this.instance;
    }
    
    constructor() {
        this._body = document.body;
        this._errCls = 'error';
        this._susCls = 'success';
        this._errIco = '&#x26A0;';
        this._successIco = '&#x2714;';
    }
    
    set body(body) {
        this._body = body;
    }
    
    get body() {
        return this._body;       
    }
    
    static error(hash, message) {
        let _body = Alert.get().body; 
        let _obj = Alert.get();
        let _code = Alert.getCode();
        _body.innerHTML += Alert.htmlError(_code, _obj._errCls, _obj._errIco, hash, message);
        //Alert.addOutAnimation(_code, 3000);
    }
    
    static success(message) {
        let _body = Alert.get().body;
        let _obj = Alert.get();
        let _code = Alert.getCode();
        _body.innerHTML += Alert.htmlSuccess(_code, _obj._susCls, _obj._successIco, message);
        //Alert.addOutAnimation(_code, 1000);
    }
    
    static addOutAnimation(_code, time) {
        let _elem = document.getElementById(_code);
        setTimeout(function() {
            _elem.classList.add('out');
        }, time);
    }
    
    static htmlError(id, cls, ico, code, msg) {
        let _html = `
            <alert id='${id}' class='alert ${cls}'>
                <ico class='ico'>
                    ${ico}
                </ico>
                <message>
                    ${code}
                    <br>
                    ${msg}
                </message>
            </alert>
        `;
        return _html;
    }
    
    static htmlSuccess(id, cls, ico, msg) {
        let _html = `
            <alert id='${id}' class='alert ${cls}'>
                <ico class='ico'>
                    ${ico}
                </ico>
                <message>                    
                    ${msg}
                </message>
            </alert>
        `;
        return _html;
    }
    
    static getCode() {
        let _time = new Date().getTime();
        let _code = `alert_${_time}`;
        return _code;
    }
}