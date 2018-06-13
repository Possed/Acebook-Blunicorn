const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

import Posts from './posts/posts'
import PostForm from './posts/postForm'

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {posts: []};
		this.onCreate = this.onCreate.bind(this);
	}

  componentDidMount() {
    client({method: 'GET', path: '/api/posts'}).then(response => {
      this.setState({posts: response.entity._embedded.posts});
    })
  }

  onCreate(post) {
    client({
      method: 'POST',
      path: '/api/posts',
      entity: post,
      headers: {'Content-Type': 'application/json'}
    })
    .then((res) => {
        client({method: 'GET', path: '/api/posts'}).then(response => {
              this.setState({posts: response.entity._embedded.posts});
            })
    })
  }

  render() {
    return (
      <div>
        <Posts posts={this.state.posts.reverse()} comments={["first comment", "second comment"]}/>
        <PostForm onCreate={this.onCreate}/>
      </div>
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
)
