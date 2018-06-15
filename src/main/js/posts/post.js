import React from 'react';
import Comments from './comment/comment';
import CommentForm from './comment/commentForm';
const client = require('../client');

class Post extends React.Component{

    constructor(props) {
        super(props);
        this.state = {comments: []};
        this.createComment = this.createComment.bind(this);
    }

    componentDidMount() {
        this.getComments();
  }

    getComments(){
        client({method: 'GET', path: "/api" + this.props.post._links.comments.href.split("api")[1]}).then(response => {
                this.setState({comments: response.entity._embedded.comments});
                console.log(this.state.comments);
            })
    }

    createComment(comment){
        client({
            method: 'POST',
            path: '/api/comments',
            entity: comment,
            headers: {'Content-Type': 'application/json'}
            })
            .then((res) => {
                this.getComments();
            })
    }

	render() {
		return [
		    <div className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div>{this.props.post.content}</div>,
		    <div>
		        <Comments allComments={this.state.comments}/>,
		        <CommentForm createComment={this.createComment} post={this.props.post}/>,
		        <hr/>
		    </div>

        ];
	}
}

export default Post;
