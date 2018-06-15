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

    createComment(comment){
        client({
            method: 'POST',
            path: '/api/comments',
            entity: comment,
            headers: {'Content-Type': 'application/json'}
            })
            .then((res) => {
                console.log(res);
            })
    }

	render() {
		return [
		    <div className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div>{this.props.post.content}</div>,
		    <CommentForm createComment={this.createComment} post={this.props.post}/>,
		    <hr/>
        ];
	}
}

export default Post;
