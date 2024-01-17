from flask import Flask,render_template
app =Flask(__name__)

# url_for('static', filename='style.css')

@app.route("/")
def index():
    return '<div>Hello word</div>'

@app.route("/hello/<name>")
def hello(name):
    return "name is :{0}".format(name)

@app.route('/<id>')
def template(id):
    return render_template('index.html',tet={ 'title':'title','id':id,'text':'hhhhhhhhhhhhhhh'}
)



if __name__=='__main__':
    app.run()
