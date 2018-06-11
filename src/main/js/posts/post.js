import React from 'react';

class Post extends React.Component{
	render() {
		return (
		    <div className='post-content'>{this.props.post.createdAt.split('T')[0] + " -- " + this.props.post.content}</div>
        )
	}
}

export default Post;
