import React from 'react';

class Post extends React.Component{
	render() {
		return [
		    <div key="one" className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div key="two">{this.props.post.content}</div>,
		    <hr key="three" />,
        ];
	}
}

export default Post;
