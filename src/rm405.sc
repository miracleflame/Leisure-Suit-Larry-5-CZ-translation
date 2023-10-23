;;; Sierra Script 1.0 - (do not remove this comment)
(script# 405)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use RTRandCycle)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm405 0
)

(local
	local0
)
(instance rm405 of LLRoom
	(properties
		picture 405
		west 400
	)
	
	(method (init)
		(proc958_0 128 405 406 407 1407)
		(gLarry init: view: 406)
		(clubOwner init: setCycle: Fwd)
		(gLarry edgeHit: 0 setLoop: 1)
		(ownersDoor init: caller: rm405)
		(gLongSong number: 405 flags: 1 setLoop: -1 play:)
		(super init:)
	)
	
	(method (dispose)
		(gLongSong fade: 0 15 12 1 self)
		(super dispose:)
	)
	
	(method (cue)
		(if (== (ownersDoor state?) 0)
			(self setScript: sCartoon)
		)
	)
)

(instance ownersDoor of Door
	(properties
		x 94
		y 114
		description {the door}
		approachX 109
		approachY 124
		view 405
		signal $4000
		entranceTo 400
		moveToX 71
		moveToY 123
		enterType 0
		exitType 0
	)
)

(instance clubOwner of Prop
	(properties
		x 218
		y 140
		view 407
	)
)

(instance the_Piano_Pit_Manager of Talker
	(properties
		nsTop 13
		nsLeft 10
		view 1407
		loop 3
		viewInPrint 1
		name "the Piano Pit Manager"
	)
	
	(method (init)
		(= eyes ownerEyes)
		(= bust ownerBust)
		(= mouth ownerMouth)
		(super init: &rest)
	)
)

(instance ownerBust of Prop
	(properties
		view 1407
		loop 1
	)
)

(instance ownerEyes of Prop
	(properties
		nsTop 9
		nsLeft 31
		view 1407
		loop 2
		cycleSpeed 70
	)
)

(instance ownerMouth of Prop
	(properties
		nsTop 15
		nsLeft 36
		view 1407
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveTo 165 137 self setPri: 15)
			)
			(1
				(gLarry setLoop: 0 setCycle: End self)
			)
			(2
				(clubOwner setCycle: 0 setCel: 0 stopUpd:)
				(proc0_18 gLarry 405 0 67 15 15 70 160)
				(proc0_18 the_Piano_Pit_Manager 405 1 108 139 self)
			)
			(3 (= ticks 30))
			(4
				(proc0_18 the_Piano_Pit_Manager 405 2 108 139 self)
			)
			(5 (= ticks 123))
			(6
				(proc0_18 gLarry 405 3 67 15 15 70 160)
				(= seconds 3)
			)
			(7
				(proc0_18 the_Piano_Pit_Manager 405 4 108 139 self)
			)
			(8 (= ticks 60))
			(9
				(proc0_18 the_Piano_Pit_Manager 405 5 108 139 self)
			)
			(10 (= ticks 60))
			(11
				(proc0_18 the_Piano_Pit_Manager 405 6 108 139 self)
			)
			(12 (= ticks 60))
			(13
				(proc0_14 405 7 67 -1 185)
				(proc0_18 the_Piano_Pit_Manager 405 8 108 139 self)
			)
			(14 (= ticks 30))
			(15
				(proc0_18 the_Piano_Pit_Manager 405 9 108 139 self)
			)
			(16 (= ticks 123))
			(17
				(proc0_18 gLarry 405 10 67 15 15 70 160)
				(proc0_18 the_Piano_Pit_Manager 405 11 108 139 self)
			)
			(18 (= ticks 123))
			(19
				(proc0_18 gLarry 405 12 67 15 15 70 160)
				(proc0_18 the_Piano_Pit_Manager 405 13 108 139 self)
			)
			(20 (= ticks 60))
			(21
				(proc0_18 the_Piano_Pit_Manager 405 14 108 139 self)
			)
			(22 (= ticks 123))
			(23
				(proc0_18 gLarry 405 15 67 15 15 70 160)
				(proc0_18 the_Piano_Pit_Manager 405 16 108 139 self)
			)
			(24 (= ticks 60))
			(25
				(proc0_18 gLarry 405 17 67 15 15 70 160)
				(proc0_18 the_Piano_Pit_Manager 405 18 108 139 self)
			)
			(26 (= ticks 123))
			(27
				(gLarry cel: 4 setCycle: Beg self)
				(clubOwner startUpd: setCycle: Fwd)
			)
			(28
				(proc0_18 gLarry 405 19 67 15 15 70 160)
				(gLarry
					setCycle: Fwd
					setLoop: 2
					setMotion: MoveTo 109 124 self
				)
			)
			(29
				(gLarry setCycle: 0)
				(gLarry setPri: -1)
				(= cycles 1)
			)
			(30
				(ownersDoor setCycle: End self)
				(if (ownersDoor openSnd?)
					((Sound new:) number: (ownersDoor openSnd?) play:)
				)
			)
			(31
				(gLarry
					setCycle: Fwd
					setPri: -1
					setMotion: MoveTo 71 123 self
				)
			)
			(32
				(global2 newRoom: (global2 west?))
			)
		)
	)
)
