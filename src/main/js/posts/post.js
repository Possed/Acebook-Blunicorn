import React from 'react';

class Post extends React.Component{

//    updateLikes() = {
//        console.log("test");
//    }

	render() {
		return [
		    <div key="one" className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div key="two">{this.props.post.content}</div>,
		    <span key="four">Likes: {this.props.post.likes}  </span>,
		    <span key="five"><button><b>LIKE</b></button></span>,
		    <hr key="three" />,
        ];
	}
}

export default Post;
