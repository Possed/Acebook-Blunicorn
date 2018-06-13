import React from 'react';

class Comment extends React.Component{
    render() {
        return (
            <div key="c2">{this.props.comment}</div>
        )
    }
}

export default Comment;