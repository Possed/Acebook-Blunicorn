import React from 'react';
import Comments from '../comment/comments';

class Post extends React.Component{

    constructor(props) {
        super(props);
        this.state = {comments: [], user=this.props.user};
        this.createComment = this.createComment.bind(this);
        this.createComment = this.createComment.bind(this);
    }

     componentDidMount() {
        this.getComments(this.getComments(this.getId(this.props.post._links.self.href)));
     }

     getComments(id) {
        client({method: 'GET', path: '/api/posts' + id + '/comments'}).then(response => {
            this.setState({comments: response.entity._embedded.comments});
        });
     }

     getId(string) {
        var array = string.split('/');
        return arr[array.length-1];
     }

      createComment(comment) {
        client({
          method: 'POST',
          path: '/api/comments',
          entity: comment,
          headers: {'Content-Type': 'application/json'}
        })
        .then((res) => {
            this.getComments(this.getId(this.props.post._links.self.href))
        });
      }

	render() {
		return [
		    <div key="one" className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div key="two">{this.props.post.content}</div>,
		    <Comments key="three" comments={this.state.comments}/>,
		    <hr key="four" />,
        ];
	}
}

export default Post;
