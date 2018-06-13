import React from 'react';
import Comments from '../comment/comments';

class Post extends React.Component{
	render() {
		return [
		    <div key="one" className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div key="two">{this.props.post.content}</div>,
		    <Comments key="three" comments={this.props.comments}/>,
		    <hr key="four" />,
        ];
	}
}

export default Post;
