import React from 'react';

class PostForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value})
    }

    handleSubmit(event) {
        var newPost = {};
        newPost["content"] = this.state.value;
        this.props.onCreate(newPost);
        event.preventDefault();
    }

	render() {
		return (
		        <div>
                    <form id="postForm" onSubmit={this.handleSubmit}>
                        <textarea id="newPost" rows="4" cols="50" value={this.state.value} onChange={this.handleChange} />
                        <button type="submit">Post</button>
                    </form>
                </div>
		)
	}
}

export default PostForm;