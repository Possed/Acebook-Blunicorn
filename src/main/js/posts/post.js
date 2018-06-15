import React from 'react';

class Post extends React.Component{

    constructor(props) {
        super(props);
        this.state = this.props;
        this.updateLikes = this.updateLikes.bind(this);
    }

    updateLikes() {
        var thing = (this.state.post.likes +=1);
        this.setState({likes: thing})
    }

	render() {
		return [
		    <div key="one" className='post-content'>{this.props.post.createdAt.split('T')[0]}</div>,
		    <div key="two">{this.props.post.content}</div>,
		    <span key="four">Likes: {this.props.post.likes}  </span>,
		    <span key="five"><button><b onClick={this.updateLikes}>LIKE</b></button></span>,
		    <hr key="three" />,
        ];
	}
}

export default Post;
